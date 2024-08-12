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

    public static void updatePreparedStatement(Producer producer) {
        try (Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = preparedStatementUpdate(conn, producer)) {
            int rowsAffected = ps.executeUpdate();
            log.info("Updated producer '{}', rows affected: '{}'", producer.getId(), rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to update producer '{}'", producer.getId(), e);
        }
    }

    private static PreparedStatement preparedStatementUpdate(Connection connection, Producer producer) throws SQLException {
        String sql = "UPDATE `anime_store`.`producer` SET `name` = ? WHERE (`id` = ?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, producer.getName());
        ps.setInt(2, producer.getId());
        return ps;
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

    // A primeira coisa que a gente precisa fazer é que quando a gente está criando o Statement a gente precisa falar aqui o 
    // resultSetType que a gente quer trabalhar e a parte da concorrência, então agora a gente está criando um Statement com
    // as características do ResultSet
    public static void showTypeScrollWorking() {
        String sql = "SELECT * FROM anime_store.producer;";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {
                // Agora que nós temos aqui o ResultSet digamos que você quer ir pra última linha para isso você pode chamar
                // Baseado na sua query e não no estado do banco que você vê lá
                log.info("Last row? '{}'", rs.last());

                // Número da linha
                log.info("Row number: '{}'", rs.getRow());
                log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());

                // Primeira linha
                log.info("First row? '{}'", rs.first());
                log.info("Row number: '{}'", rs.getRow());
                log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());

                // Linha específica
                log.info("Row Absolute '{}'", rs.absolute(2));
                log.info("Row number: '{}'", rs.getRow());
                log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());

                // Trabalhando de forma relativa, digamos que eu quero voltar uma linha
                log.info("Row relative? '{}'", rs.relative(-1));
                log.info("Row number: '{}'", rs.getRow());
                log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());

                // Se você quer saber onde você está sem você querer mover o cursor, por exemplo, quero saber se é a última ou quero
                // saber se é a primeira
                // O isLast ele verifica se é a última e ele não move o cursor
                log.info("is last? '{}'", rs.isLast());
                log.info("Row number: '{}'", rs.getRow());

                // Da mesma forma que você tem o isLast você tem o isFirst
                log.info("is first? '{}'", rs.isFirst());
                log.info("Row number: '{}'", rs.getRow());

                // E você tem o isBeforeFirst e o isAfterLast por que que é importante? Porque digamos assim que você quer ir pra última
                // posição e digamos que eu quero ir de baixo pra cima agora e como eu faço pra ir de baixo pra cima? Utilizando um while
                // vou fazer rs.previous e vou imprimir todos aqui
                log.info("Last row? '{}'", rs.last());
                log.info("-------------------------");

                // Eu estava na última fui mais uma
                rs.next();

                // E eu quero saber se está depois do fim da nossa tabelinha
                // Como você pode ver agora está depois e quando eu falei vai pra trás ele pegou Studion Deen, NHK e MADHOUSE
                log.info("After last row? '{}'", rs.isAfterLast());

                // Como você pode ver nós temos o primeiro que é o NHK e depois nós temos o MADHOUSE como você pode ver a gente pulou o
                // último e por que a gente pulou o último? Porque se você voltar aqui começando do último ele estava em Studio Deen falei
                // previous ele moveu pra NHK e aí apareceu NHK e MADHOUSE, ou seja, ele pulou o último porque ele já estava na última 
                // posição eu teria que ir pra uma posição mais a frente do último por isso você tem o isAfterLast
                while (rs.previous()) {
                    log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
                }
        } catch (SQLException e) {
            log.error("Error while trying to find producer by name", e);
        }
    }

    // Basicamente a gente vai procurar por um nome e o nome que a gente achar a gente vai fazer a atualização colocando ele em UpperCase
    // sem criar um novo sql
    // O metodo fica da mesma forma, mas como nós estamos criando um Statement que vai fazer uma atualização no banco de dados lembre-se que
    // a gente precisa utilizar o ResultSet que é insensitive e updatable
    public static List<Producer> findByNameAndUpdateToUpperCase(String name) {
        log.info("Finding Producers by name");
        String sql = "SELECT * FROM anime_store.producer WHERE name LIKE '%s';".formatted("%" + name + "%");
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {
            // O nome que você tem já está dentro da memória o ResultSet quando você executa a query ele traz aqueles dados para dentro da
            // memória e você fica trabalhando com ele dentro da memória que é o que nós temos aqui
            while (rs.next()) {
                // A gente vai atualizar aqui em cima antes de criar esse cara nós vamos fazer o seguinte, então basicamente estou falando
                // atualiza o ResultSet pega a coluna nome você pega o valor que você tem dentro daquela célula e coloca ele pra UpperCase
                // O updateString quando você quiser, por exemplo, dar um rollback quando você quiser desfazer as alterações ao invés de 
                // você tentar setar digamos você mudou de ideia e quer setar para toLowerCase ou você queira voltar quando você tiver esse
                // caso você tem que utilizar o cancelRowUpdates e ele só pode ser utilizado antes do updateRow e uma vez que você utilizou
                // updateRow não tem mais como você cancelar o update
                // Então, sempre que você quiser voltar o estado utilize cancelRowUpdates ao invés de você tentar pegar o valor que está no
                // banco de dados, por exemplo, não utilize updateString duas vezes
                rs.updateString("name", rs.getString("name").toUpperCase());

                // rs.cancelRowUpdates();

                // Enquanto você não utiliza o updateRow ele não vai estar atualizando, então todas as vezes que você estiver utilizando o
                // updateString você tem que lembrar de utilizar o updateRow porque se não não vai ser persistido no banco de dados e outra
                // coisa importante também é que quando você está fazendo a atualização não é necessário você criar um novo sql
                rs.updateRow();
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

    // Nós vamos procurar pelo nome e se não existir nós vamos inserir
    public static List<Producer> findByNameAndInsertWhenNotFound(String name) {
        log.info("Finding Producers by name");
        String sql = "SELECT * FROM anime_store.producer WHERE name LIKE '%s';".formatted("%" + name + "%");
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {
            // Para deixar o código mais limpo o que poderíamos fazer é
            if (rs.next()) {
                return producers;
            }

            insertNewProducer(name, rs);

            // Depois de inserir para pegar esse cara a gente pode fazer
            Producer producer = getProducer(rs);

            // Se você quisesse deletar é bem simples basta utilizar deleteRow e você não precisa persistir porque o
            // deleteRow ele literalmente deleta direto não tem o que você fazer

            producers.add(producer);

            // E aí vou fazer o seguinte se o next for igual a falso, ou seja, significa que se não tiver o próximo o que
            // eu quero fazer? Eu quero inserir e como a gente faz pra inserir?
            // if (!rs.next()) {
            //     // Primeiro preciso mover o cursor para uma linha temporária
            //     rs.moveToInsertRow();

            //     // Depois que eu mover para essa linha o que eu quero fazer? Na coluna name vou adicionar o name que procuramos
            //     // aqui
            //     rs.updateString("name", name);

            //     // Então, depois que você atualizou como a gente faz pra inserir? 
            //     rs.insertRow();

            //     // Depois de inserir para pegar esse cara a gente pode fazer
            //     // Basicamente como não tinha nada a gente voltou para o primeiro
            //     rs.beforeFirst();

            //     rs.next();

            //     Producer producer = Producer
            //         .builder()
            //         .id(rs.getInt("id"))
            //         .name(rs.getString("name"))
            //         .build();

            //     producers.add(producer);
            // }
        } catch (SQLException e) {
            log.error("Error while trying to find producer by name", e);
        }
        return producers;
    }

    public static void findByNameAndDelete(String name) {
        log.info("Finding Producers by name");
        String sql = "SELECT * FROM anime_store.producer WHERE name LIKE '%s';".formatted("%" + name + "%");
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                log.info("Deleting '{}'", rs.getString("name"));
                rs.deleteRow();
            }
        } catch (SQLException e) {
            log.error("Error while trying to find producer by name", e);
        }
    }

    private static void insertNewProducer(String name, ResultSet rs) throws SQLException {
        // Primeiro preciso mover o cursor para uma linha temporária
        rs.moveToInsertRow();

        // Depois que eu mover para essa linha o que eu quero fazer? Na coluna name vou adicionar o name que procuramos
        // aqui
        rs.updateString("name", name);

        // Então, depois que você atualizou como a gente faz pra inserir? 
        rs.insertRow();
    }

    private static Producer getProducer(ResultSet rs) throws SQLException {
        // Basicamente como não tinha nada a gente voltou para o primeiro
        rs.beforeFirst();

        rs.next();

        Producer producer = Producer
            .builder()
            .id(rs.getInt("id"))
            .name(rs.getString("name"))
            .build();
        return producer;
    }

    // PreparedStatement ele basicamente é um Statement aonde a performance vai ser muito maior porque quando você está utilizando
    // SQL normal e você manda para o banco de dados o banco de dados tem que checar se a sintaxe está correta, checar se o nome da
    // tabela está correto, checar se as palavras as colunas que você tenha mandado estejam corretas, ou seja, tem vários passos que 
    // podem ser adiantados diretamente na aplicação e esse é um dos pontos que o PreparedStatement ele te ajuda, então ele pré compila
    // o seu SQL pra agilizar a sua query e outra coisa também ele dá uma proteçãozinha contra o que nós chamamos de SQL Injection

    // Vamos mostrar o que é um SQL Injection, imagine aqui que a gente não teria o like a gente está procurando pelo nome e a gente só
    // tem o %s
    // Do jeito que nós desenvolvemos aqui o nosso repositório a gente está dando possibilidade para SQL Injection e como é que funciona
    // o SQL Injection? Imagina que agora no meu findByName, isso é algo que está vindo do usuário e o usuário poderia descrever mais ou
    // menos assim no input B or 'X' = 'X' e agora nós conseguimos obter todos os dados da nossa tabela, então um dos objetivos do
    // PreparedStatement é você dar uma filtrada nesses caras

    // Então como a gente trabalha com PreparedStament? Voltando aqui no nosso código a gente só precisa fazer algumas pequenas alterações
    // A primeira trocamos a conexão para prepareStatement e você está vendo que aqui ele pede agora o SQL quando você passa o SQL para o
    // PreparedStament e o PreparedStatement é um Statement por isso você tem aqui essa possibilidade de continuar utilizando polimorfismo
    // deixando o Statement lá, mas queremos trocar aqui para PreparedStatement
    // Mas, eu não quero executar a query dessa forma o que eu quero fazer? Antes de executar a query eu quero começar a fazer a proteção
    // fazer a pré compilação desse valor que eu tenho aqui no SQL, então a primeira coisa que a gente vai fazer vai ser tirar o formatted
    // e aqui onde tinha esse símbolo '%s' a gente tira e o name LIKE ? que é o que chamamos de wild card
    // Agora que a gente tem essa ? como a gente faz para pegar os valores? A gente precisa antes de executar a nossa query nós precisamos
    // setar o substituir os nossos wild cards e aqui as coisas começam a ficar um pouquinho complicadas porque você tem que executar a query
    // de uma forma aonde o seu ResultSet vai estar aqui e ao mesmo tempo você precisa adicionar aqui o que nós chamamos de setString só que
    // se você colocar um valor aqui você tem um problema porque você não pode utilizar chamadas dentro do try with resources, então a gente
    // vai ter que fazer o seguinte colocar dentro do bloco try o setString e o nosso ResultSet
    // Então, a gente está pré compilando o nosso PreparedStatement aonde você tem esse valor aqui, o índice sempre começa de 1, e ele vai
    // substituir por esse name e temos um pequeno probleminha como é que a gente vai fechar esse ResultSet aqui? A gente pode extrair a
    // complexidade de criar um PreparedStatement para um outro método porque o que importa é você ter um PreparedStatement criado aqui dentro
    // do try
    // Basicamente o PreparedStatement ele foi criado pra você ter essa proteçãozinha contra o SQL Injection e também pra ter uma melhor
    // performance porque o SQL vai ser pré compilado pra você evitar também de ter que criar outro try with resources aninhado você coloca a
    // resposanbilidade de criar o PreparedStatement em um outro método
    public static List<Producer> findByNamePreparedStament(String name) {
        log.info("Finding Producers by name");
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = preparedStatementFindByName(conn, name);
             ResultSet rs = ps.executeQuery()) {

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

    private static PreparedStatement preparedStatementFindByName(Connection connection, String name) throws SQLException {
        String sql = "SELECT * FROM anime_store.producer WHERE name LIKE ?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, "%"+name+"%");
        return ps;
    }

    // CallableStatement basicamente é uma versão mais especializada do PreparedStatement, mas a diferença é que o Callable ele vai
    // executar procedures e functions a diferença é que functions precisa obrigatoriamente retornar um valor e stored procedures
    // você tem a escolha entre retornar e não retornar determinado valor
    // Então, aqui a gente vai criar uma stored procedure antigamente era bastante comum utilizar stored procedures hoje em dia não é
    // tão frequente a sua utilização porque quando você coloca a regra de negócio no banco de dados as coisas geralmente tendem a ser
    // mais complicadas de se dar manutenção
    // Então, por que seria útil? Porque imagina que as vezes você tem umas tabelas com dados sensitivos e você não quer que as pessoas
    // possam executar uma busca em todos os campos da tabela, então se você limitar falar que ninguém pode acessar a tabela e se você
    // quiser fazer consulta ou inserção você faria diretamente via procedure, é mais uma coisa de como as coisas ficariam organizadas
    public static List<Producer> findByNameCallableStament(String name) {
        log.info("Finding Producers by name");
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = callableStatementFindByName(conn, name);
             ResultSet rs = ps.executeQuery()) {

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

    private static CallableStatement callableStatementFindByName(Connection connection, String name) throws SQLException {
        String sql = "CALL anime_store.sp_get_producer_by_name(?);";
        CallableStatement cs = connection.prepareCall(sql);
        cs.setString(1, "%"+name+"%");
        return cs;
    }

    // Transações basicamente é atomicidade no banco de dados, ou seja, ou você executa tudo ou você não executa nada, então tem
    // casos que é extremamente útil imagina por exemplo que você está trabalhando com um banco de dados que trabalha com estoque
    // e alguém faz uma compra de um monitor quando você faz a compra você tem vários passos você tem o monitor que precisa estar
    // no estoque aí se alguém for fazer o pagamento o pagamento precisa ser bem sucedido e aquele monitor precisa sair do estoque
    // ou seja, você tem vários passos que precisam ser feitos no banco de dados caso um deles dê errado você precisa voltar tudo
    // ao estado original então isso é chamado de transação ou você faz tudo ou você não faz nada

    // O que precisamos alterar aqui? Primeiro nós vamos receber uma lista de producers, ou seja, é tipo um patch save a gente vai
    // mandar vários dados a gente quer que todos os dados sejam inseridos no banco ou eles não sejam inseridos no banco de dados
    // caso um dê problema
    public static void saveTransaction(List<Producer> producers) {
        try (Connection conn = ConnectionFactory.getConnection()) {
            // Como é que a gente fala pro banco não alterar? Porque por padrão o MySQL ele tem algo que nós chamamos de autocommit
            // ou seja, toda vez que você executa esse execute basicamente você está falando pro banco olha pega esse SQL aí e insere
            // só que o que acontece você tem 3 producers A, B e C mandou A pro banco salvou, mandou B pro banco salvou, mandou C pro
            // banco deu exceção o que acontece? A e B já estão salvos, mas você não quer que A e B sejam salvos se um deles der problema
            // então você precisa desativar isso e você desativa através da conexão setAutoCommit para falso, ou seja, eu não quero que
            // o banco tome conta de salvar cada um dos SQLs que estou mandando quando você faz isso não importa que você chame o execute
            // que ele não vai salvar
            conn.setAutoCommit(false);
            preparedStatementSaveTransaction(conn, producers);

            // Precisamos falar que depois que você termina de fazer toda a transação você comit
            conn.commit();

            // A propósito se você estivesse trabalhando num método maior uma vez que você seta o AutoCommit pra falso você precisa voltar
            // ele para true por conexão
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            log.error("Error while trying to save producers '{}'", producers, e);
        }
    }

    // Então, eu preciso não montar só um, mas montar vários PreparedStatement preciso executar eles e caso algum dê problema eu
    // preciso voltar todo mundo, por isso não posso ter o PreparedStatement no saveTransaction porque eu preciso dele dentro de
    // um loop, mas você não quer criar uma conexão para cada um dos producers que você quer salvar você cria uma conexão e você
    // reusa essa conexão até você finalizar esse método, na verdade você precisa de um pool de conexões você não pode ficar
    // criando conexões aleatórias assim porque se não você extoura o limite do banco de dados, mas geralmente quando você está
    // trabalhando com Java existem alguns frameworks que fazem isso pra você
    private static void preparedStatementSaveTransaction(Connection conn, List<Producer> producers) throws SQLException {
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES (?);";
        boolean shouldRollback = false;

        // Iterando sobre todos os producers que nós tivermos
        for (Producer p : producers) {
            // Aqui dentro precisamos criar o PreparedStatement, mas nós também precisamos fechá-lo então para isso usamos um
            // try with resources
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                log.info("Saving producer '{}'", p.getName());

                // Para cada um deles estou setando o nome
                ps.setString(1, p.getName());

                if (p.getName().equals("White Fox")) {
                    throw new SQLException("Can't save white fox");
                }

                // Depois que eu seto o nome o que eu quero fazer? Então, estou criando cada um dos producers que estou passando
                // aqui dentro desse for
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
                shouldRollback = true;
            }
        }
        if (shouldRollback) {
            log.warn("Transaction is going to be rollkack");
            conn.rollback();
        }
    }
}
