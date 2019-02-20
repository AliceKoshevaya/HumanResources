package db.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;

public class ConnectionManager {
    private static final String URL = "jdbc:mysql://localhost:3306/human_resources?serverTimezone=Europe/Amsterdam&amp&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private Collection<Connection> connections = Collections.emptyList();


    public static Connection getConnection() {
        try  {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Class.forName("com.mysql.cj.jdbc.Driver");
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
