package academy.devdojo.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
}
