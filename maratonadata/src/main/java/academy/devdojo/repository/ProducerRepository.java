package academy.devdojo.repository;

import academy.devdojo.conn.ConnectionFactory;
import academy.devdojo.dominio.Producer;
import lombok.extern.log4j.Log4j2;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public static void update(Producer producer) {
        String sql = "UPDATE `anime_store`.`producer` SET `name` = '%s ' WHERE (`id` = '%d');".formatted(producer.getName(), producer.getId());

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);

            // PII (Personally Identifiable Information) -> geralmente você evita colocar dados que podem identificar uma pessoa no log
            log.info("Updated producer '{}', rows affected: '{}'", producer.getId(), rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to update producer '{}'", producer.getId(), e);
        }
    }

    // O findAll é um metodo que vai trazer todos os dados do nosso banco, geralmente você não tem um findAll em bancos
    // de dados de verdade quando você coloca o seu aplicativo na produção porque isso literalmente vai trazer todos
    public static List<Producer> findAll() {
        log.info("Finding all Producers");
        return findByName("");
//        //String sql = "SELECT id, name FROM `anime_store`.`producer`";
//
//        // Pra você trazer os dados você tem que utilizar o ResultSet, mas o ResultSet você cria a partir de um
//        // Statement
//        // Como funciona o ResultSet? O ResultSet funciona assim quando você tem o ResultSet ele vai ter um cursor no
//        // começo a primeira vez que você executa a query esse cursor está apontando pra nada e agora quando você for
//        // navegar você vai precisar fazer algo parecido com o que você fez com Iterator você vai ter que verificar se
//        // existe o próximo o rs.next vai pegar a primeira linha, depois a segunda linha, terceira linha e quando acabar
//        // por exemplo ele vai retornar falso, ou seja, esse cara tem que estar dentro de um while
//
//        // Primeiro a gente tem que criar aqui uma lista de Producer porque nós vamos adicionar toda essa galera
//        // dentro desse ArrayList, cada uma dessas linhas vai virar um objeto no Java e aí como você faz pra você
//        // colocar as colunas? Porque você tem id que é int, você tem o name que é varchar
//        List<Producer> producers = new ArrayList<>();
//
//        try (Connection conn = ConnectionFactory.getConnection();
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery(sql)) {
//            // Enquanto o meu ResultSet tiver próximo, ou seja, rs.next
//            while (rs.next()) {
//                // Eu preciso criar o objeto, então como é que você pega os dados da coluna? Tem duas formas você pode
//                // pegar rs e o tipo da coluna, por exemplo rs.getInt para pegarmos o id, e você tem duas opções um você
//                // passa o índice da coluna ou você passa o nome da coluna. O índice da coluna sempre começa com 1,
//                // então se eu passar 1 estou me referindo ao id, mas para ser bem explícito é preferível passar o nome
//                // da coluna, você pode criar variáveis locais
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//
//                // Agora que nós temos os dados precisamos criar um objeto
//                Producer producer = Producer.builder().id(id).name(name).build();
//
//                // Adicionando na lista de Producers o objeto que criamos, ou seja, para cada uma das linhas que nós
//                // temos no nosso banco ele vai pegar o id, name criar um objeto Producer adicionar no nosso ArrayList
//                // e assim ele vai continuar, mas você tem que tomar muito cuidado porque o ArrayList aceita valores
//                // duplicados
//                producers.add(producer);
//            }
//        } catch (SQLException e) {
//            log.error("Error while trying to find all producers", e);
//        }
//
//        return producers;
    }

    public static List<Producer> findByName(String name) {
        log.info("Finding Producers by name");
        String sql = "SELECT * FROM anime_store.producer WHERE name LIKE '%s';".formatted("%" + name + "%");
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Producer producer = Producer
                        .builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            log.error("Error while trying to find producer by name", e);
        }

        return producers;
    }

    // O ResultSet é muito poderoso ele não serve apenas para trazer os dados uma das coisas que podemos fazer com ele
    // é trabalhar com metadados, como você sabe o ResultSet está conectado diretamente aqui na nossa tabela e nós
    // pegamos os dados diretamente quando nós estávamos utilizando a criação do objeto, porém existem possibilidades
    // maiores, por exemplo, ResulSet em alguns drivers te possibilita alterar os registros, então você está navegando
    // você consegue alterar o registro, ou então você consegue pegar o nome da tabela que você está trabalhando, você
    // consegue até pegar mesmo a quantidade de colunas, o nome da coluna, o tamanho que aquela coluna permite, então
    // o ResultSet é bem mais poderoso que só trazer os dados de volta do banco de dados
    // E a primeira coisa que a gente vai fazer é pegar os metadados porque nem sempre você tem acesso a query às vezes
    // você não sabe exatamente quais são os campos que você precisa trabalhar às vezes uma query vem de um sistema
    // externo e aí a gente vai ver agora, por exemplo, como a gente pode identificar
    public static void showProducerMetaData() {
        log.info("Showing Producer Metadata");
        String sql = "SELECT * FROM anime_store.producer;";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Eu quero saber alguns metadados, por exemplo, pra pegar os metadados você pode pegar através
            // rs.getMetaData e como você pode ver ele retorna pra gente um ResultSetMetaData
            ResultSetMetaData rsMetaData = rs.getMetaData();

            // Vamos trabalhar com uma única coluna, então vamos dar rs.next para que ele possa andar uma linha
            rs.next();

            // Após ele andar uma linha nós vamos pegar alguns dados, por exemplo
            // Quantidade de colunas que eu tenho na minha tabela
            int columnCount = rsMetaData.getColumnCount();
            log.info("Columns count '{}'", columnCount);
            
            // Se a gente tem um columnCount nós podemos fazer um for
            for (int i = 1; i <= columnCount; i++) {
                log.info("Table name '{}'", rsMetaData.getTableName(i));
                log.info("Column name '{}'", rsMetaData.getColumnName(i));
                log.info("Column size '{}'", rsMetaData.getColumnDisplaySize(i));
                log.info("Column type '{}'", rsMetaData.getColumnTypeName(i));
            }
        } catch (SQLException e) {
            log.error("Error while trying to find producer by name", e);
        }
    }

    // Vimos que o ResultSet é bem poderoso podemos pegar os dados da tabela, mas também tem uma forma como o ResulSet
    // vai se comportar quando você estiver navegando, por exemplo, ele pode navegar sempre de cima pra baixo, de baixo
    // pra cima ou de uma posição específica ou ainda tem a possibilidade do ResultSet atualizar os campos sem você
    // precisar escrever um novo SQL e tem uma possibilidade também de quando você está navegando e, por exemplo, uma
    // outra pessoa alterar o banco de dados o ResultSet pode refletir essas alterações ou pode não refletir essas
    // alterações, então tudo isso é parte do ResultSet que nós podemos pegar através dos metadados
    // Vamos pegar os metadados do nosso driver porque é o driver que decide isso, lembre-se que o driver é a
    // implementação do nosso JDBC, no nosso caso a gente está usando MySQL, e precisa verificar o que esse driver
    // suporta
    public static void showDriverMetaData() {
        log.info("Showing Driver Metadata");

        try (Connection conn = ConnectionFactory.getConnection()) {
            // A gente precisa saber os metadados dessa conexão, então nós temos um DatabaseMetaData
            DatabaseMetaData dbMetaData = conn.getMetaData();

            // E aí vem a parte onde a gente verifica se suporta se você for dentro de Connection você pode ver os três
            // tipos de Types
            // TYPE_FORWARD_ONLY -> vai de cima para baixo
            if (dbMetaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
                log.info("Supports TYPE_FORWARD_ONLY");

                // E aí a gente precisa verificar também se ele suporta alterar os dados enquanto você está navegando
                // nesse ResultSet
                // Como eu quero executar as três condições usamos if e não else
                if (dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("And Supports CONCUR_UPDATABLE");
                }
            }

            // O TYPE_SCROLL_INSENSITIVE significa que você pode navegar de cima pra baixo, de baixo pra cima e ele não
            // atualiza os dados em tempo real, então por exemplo, digamos que é como se fosse um cache ele praticamente
            // coloca na memória aquele ResultSet, então se alguém chegar lá enquanto você está fazendo um ResultSet e
            // ao mesmo alterar os dados, o que vai acontecer? Esses dados não vão ser representados no ResultSet porque
            // é insensitivo
            if (dbMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                log.info("Supports TYPE_SCROLL_INSENSITIVE");

                // Como ele é insensitivo nós também verificamos se ele suporta atualização
                if (dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("And Supports CONCUR_UPDATABLE");
                }
            }

            // Por último nós temos o sensitivo que é o contrário significa que se você estiver navegando no seu ResultSet e
            // alguém faz alguma alteração no banco de dados porque geralmente você tem várias pessoas, quando falamos várias
            // pessoas dentro de uma aplicação WEB significa que várias conexões estão acontecendo no banco de dados e se você
            // estiver navegando esse cara aqui ele vai possibilitar você de ver o resultado da alteração diretamente no seu
            // ResultSet sem que você precise fazer uma nova busca, mas isso é extremamente difícil de ser implementado e são
            // pouquíssimos os drivers que suportam esse cara
            if (dbMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                log.info("Supports TYPE_SCROLL_SENSITIVE");

                if (dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("And Supports CONCUR_UPDATABLE");
                }
            }
        } catch (SQLException e) {
            log.error("Error while trying to find producer by name", e);
        }
    }
}
