package academy.devdojo.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

// Essa classe vai ser responsável por criar a nossa conexão com o banco de dados
// JDBC (Java Database Connectivity) é basicamente uma biblioteca que foi criado para o Java para tentar padronizar a
// conexão com diferentes tipos de banco de dados
// A gente vai definir uma interface aqui e a partir dessa interface as empresas responsáveis pela criação do banco de
// dados vão criar os conectores, basicamente o Java criou uma interface chamada:
// java.sql = Connection, Statement, ResultSet, DriverManager
public class ConnectionFactory {
    // Para montar uma conexão precisamos de algumas coisas: precisamos da url, usuário e a senha
    // A url é uma das partes mais importantes, a url vai possibilitar o DriverManager pegar uma conexão porque tem um
    // padrão os bancos de dados possuem um padrão de url
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3307/anime_store";
        String username = "root";
        String password = "root";

        // E aí a gente precisa pegar a conexão, geralmente quando você está trabalhando com conexão você precisa tratar
        // exceção é algo que está além do poder do desenvolvedor
//        try {
//            return DriverManager.getConnection(url, username, password);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

        // Mudamos a abordagem e colocamos a exceção na assinatura do metodo
        // Retornando a nossa conexão
        return DriverManager.getConnection(url, username, password);
    }

    // Basicamente é dessa forma que a gente consegue um JdbcRowSet que é como se fosse um ResultSet vai manter uma conexão
    // com o banco de dados ou não e a partir dele a gente consegue pegar os dados do banco de dados
    public static JdbcRowSet getJdbcRowSet() throws SQLException {
        String url = "jdbc:mysql://localhost:3307/anime_store";
        String username = "root";
        String password = "root";
        JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
        jdbcRowSet.setUrl(url);
        jdbcRowSet.setUsername(username);
        jdbcRowSet.setPassword(password);
        return jdbcRowSet;
    }

    // O CachedRowSet ele difere do RowSet do JdbcRowSet porque o JdbcRowSet ele é um RowSet conectado e o CachedRowSet ele não
    // é conectado ele basicamente pega os dados e desconecta e você trabalha com os dados em memória
    // Então, basicamente pra você pegar o CachedRowSet é exatamente a mesma coisa
    public static CachedRowSet getCachedRowSet() throws SQLException {
        return RowSetProvider.newFactory().createCachedRowSet();
    }
}
