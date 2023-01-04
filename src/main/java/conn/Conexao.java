package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static Connection getConnection() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/futebol";
        String username = "root";
        String password = "root";
        return DriverManager.getConnection(url, username, password);
    }
}
