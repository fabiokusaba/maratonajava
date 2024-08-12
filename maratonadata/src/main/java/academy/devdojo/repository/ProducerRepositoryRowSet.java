package academy.devdojo.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;

import academy.devdojo.conn.ConnectionFactory;
import academy.devdojo.dominio.Producer;
import academy.devdojo.listener.CustomRowSetListener;

// Nós vamos falar agora do JdbcRowSet ele é basicamente uma versão tunada do ResultSet, quais são as diferenças? O ResultSet
// ele sempre mantém uma conexão com o banco de dados o RowSet ele pode manter uma conexão ou você pode desconectar do banco
// de dados, o ResultSet não pode ser serializado já o RowSet ele pode ser serializado, já que o ResultSet não pode ser
// serializado ele também não pode mandar um ResultSet via network e RowSet já que ele pode ser serializado você poderia mandar
// por exemplo, via network o resultado daquele RowSet e o ResultSet ele não é um Java Bean, mas o RowSet ele é um Java Bean a
// gente vai ver que a gente pode criar ele utilizando o padrão factory e by default o RowSet ele é Scrollable e Updatable
public class ProducerRepositoryRowSet {
    // E vamos criar um método muito parecido com o nosso PreparedStatement
    public static List<Producer> findByNameJdbcRowSet(String name) {
        String sql = "SELECT * FROM anime_store.producer WHERE name LIKE ?;";
        List<Producer> producers = new ArrayList<>();

        // E agora vem o nosso try, então a gente estava fazendo antes o que? O Connection depois do Connection pegava o
        // PreparedStatement depois a gente pegava a conexão com o JdbcRowSet a gente basicamente só pega o RowSet, por
        // exemplo 
        try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()) {
            // Adicionando um listener
            jrs.addRowSetListener(new CustomRowSetListener());

            // Agora que nós temos o nosso JdbcRowSet como que a gente faz para trocar o wild card aqui e adicionar o nosso
            // name? Basicamente da mesma forma que fizemos com o PreparedStatement
            // A primeira coisa que a gente precisa montar é o SQL no JdbcRowSet para montar o SQL a gente utiliza setCommand
            jrs.setCommand(sql);

            // E aí vem o setString
            jrs.setString(1, String.format("%%%s%%", name));

            // Como é que faz pra gente executar? Através do método execute, então basicamente você não pode utilizar esse execute
            // para inserir dados apenas pra buscar dados
            jrs.execute();

            // E como a gente pega os dados? No PreparedStatement e no Callable a gente estava utilizando o ResultSet.next, nesse
            // caso é só a gente trocar pra jrs.next e da mesma forma aqui a gente faz:
            while (jrs.next()) {
                Producer producer = Producer.builder()
                    .id(jrs.getInt("id"))
                    .name(jrs.getString("name"))
                    .build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producers;
    }

    // Nós vamos ver agora como fazemos para atualizar um campo
    // Como você ver tivemos uma pequena exceção, ou seja, a gente não pode fazer manipulação de dados utilizando o execute
    // daquela forma a gente não pode utilizar o update e como a gente resolve esse problema? Da mesma forma que a gente fez
    // com um ResultSet com o tipo Scrollable
    // public static void updateJdbcRowSet(Producer producer) {
    //     String sql = "UPDATE anime_store.producer SET name = ? WHERE id = ?;";

    //     try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()) {
    //         jrs.setCommand(sql);
    //         jrs.setString(1, producer.getName());
    //         jrs.setInt(2, producer.getId());
    //         jrs.execute();
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    // }

    public static void updateJdbcRowSet(Producer producer) {
        String sql = "SELECT * FROM anime_store.producer WHERE id = ?;";

        try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()) {
            jrs.addRowSetListener(new CustomRowSetListener());
            jrs.setCommand(sql);
            jrs.setInt(1, producer.getId());
            jrs.execute();

            // Quando executarmos o execute vamos ter um retorno, o retorno é o registro que nós estávamos procurando
            // então se não tiver próximo retorna porque não quero a continuação do método
            if (!jrs.next()) return;

            // Mas, e se tiver? Nós temos o updateString
            jrs.updateString("name", producer.getName());

            // E aí a gente chama o updateRow
            jrs.updateRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // O CachedRowSet como ele é um RowSet desconectado todas as alterações que você fizer nesse cara você vai ter que
    // meio que mandar denovo para o banco de dados o updateRow não é o suficiente você precisa aceitar com acceptChanges
    // mas aí as coisas começam a ficar um pouco complicadas

    // Temos que tomar um cuidado com a atualização porque como ele é um RowSet desconectado se você estiver trabalhando
    // com concorrência pode ocorrer um erro por conflito

    // Então esse é o CachedRowSet ele deixa os dados em memória portanto você tem uma performance muito maior dependendo
    // da sua máquina do que você ir lá no banco de dados e pegar os dados
    public static void updateCachedRowSet(Producer producer) {
        String sql = "SELECT * FROM producer WHERE id = ?;";
        try (CachedRowSet crs = ConnectionFactory.getCachedRowSet();
        Connection connection = ConnectionFactory.getConnection()) {
            // Com o setAutoCommit false estou falando que não quero mais que o banco de dados seja o responsável por 
            // persistir permanentemente os dados eu tenho que chamar e eu vou pegar esse connection e passar dentro do
            // execute
            connection.setAutoCommit(false);
            // crs.addRowSetListener(new CustomRowSetListener());
            crs.setCommand(sql);
            crs.setInt(1, producer.getId());
            crs.execute(connection);
            if (!crs.next()) return;
            crs.updateString("name", producer.getName());
            crs.updateRow();
            crs.acceptChanges();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
