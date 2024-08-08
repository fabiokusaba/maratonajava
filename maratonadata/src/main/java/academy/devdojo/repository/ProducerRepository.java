package academy.devdojo.repository;

import academy.devdojo.conn.ConnectionFactory;
import academy.devdojo.dominio.Producer;
import lombok.extern.log4j.Log4j2;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

// Repository é algo muito utilizado no framework Spring, mas repository basicamente são as classes que lidam
// diretamente com o banco de dados
// Tem um padrão de projetos chamado DAO (Data Access Object) que basicamente é isso

// Log4j2 é uma das melhores bibliotecas que tem pra utilização de logs que ao invés de você utilizar System.out.println
// você faz o seguinte
// Todos os logs eles tem um status no nosso caso queremos pegar todos os status de informação
// Mas, lembre-se que quando você utiliza você precisa adicionar a dependência e o arquivo de configuração

@Log4j2
public class ProducerRepository {
    // Ele vai ter um metodo chamado save e por que estático? Porque a gente não está acessando nenhum atributo de
    // classe, e aqui vou receber um Producer
    public static void save(Producer producer) {
        // Quero criar agora o SQL para inserir e como a gente faz?
        // Agora aqui no nosso sql a gente precisa mudar porque nós precisamos dos dados do produtor
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ('%s');".formatted(producer.getName());

        // Agora que a gente tem o nosso SQL pronto a gente precisa inserir, vamos inserir através do nosso
        // Statement
        // Lembre-se de que quando você está querendo alterar os dados do banco de dados você utiliza o Statement
        // Mas, aí tem um pequeno probleminha quando você está trabalhando com uma conexão você abre uma conexão e você
        // precisa fechar uma conexão para isso podemos utilizar o try com recursos
        // Nós criamos a conexão e da conexão nós precisamos pegar um Statement que é um objeto que vai ser responsável
        // por alterar os dados do banco de dados
        // Nós temos o nosso Statement e agora o nosso conn e o nosso stmt porque o Statement também precisa fechar, você
        // precisa fechar o Statement, você precisa fechar o Connection então é bom você criar dentro do try with
        // resources que ele se encarrega de fechar pra você
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            // A gente precisa agora inserir e como a gente insere? Nós utilizamos o execute, temos vários mas no nosso
            // caso como a gente quer inserir nós temos que utilizar o executeUpdate e ele retorna pra gente que pode
            // ser um INSERT, UPDATE ou DELETE basicamente tudo aquilo que for alterar o status do banco de dados e ele
            // retorna pra gente a quantidade de linhas que foram afetadas na sua execução
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Inserted producer '{}' in the database, rows affected: '{}'", producer.getName(), rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to insert producer '{}'", producer.getName(), e);
        }
    }

    public static void delete(int id) {
        String sql = "DELETE FROM `anime_store`.`producer` WHERE (`id` = '%d');".formatted(id);

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Deleted producer '{}' from the database, rows affected: '{}'", id, rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to delete producer '{}'", id, e);
        }
    }
}
