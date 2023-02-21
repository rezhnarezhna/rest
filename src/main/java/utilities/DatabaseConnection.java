package utilities;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 * The BasicDataSource class provides a simple implementation of a connection
 * pool. You can set the initial number of connections using setInitialSize()
 * and the maximum number of connections using setMaxTotal(). Once the maximum
 * number of connections has been reached, requests for connections will be
 * queued until a connection is available.
 *
 * Note that the getConnection() method is synchronized to ensure that only one
 * thread can access the connection pool at a time. This is necessary because
 * the connection pool is shared between all threads that access the database.
 *
 * @author API Project Group
 *
 */
public class DatabaseConnection {

    private static BasicDataSource dataSource;

    public static synchronized Connection getConnection() throws SQLException {
        if (dataSource == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); // Load and register JDBC driver, mysql 8
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
            dataSource = new BasicDataSource();
            dataSource.setUrl("jdbc:mysql://localhost:3306/serverdb");
            dataSource.setUsername("root");
            dataSource.setPassword("");
            dataSource.setInitialSize(5); // Number of initial connections
            dataSource.setMaxTotal(20); // Maximum number of connections
            dataSource.setMinEvictableIdleTimeMillis(300000);
        }
        return dataSource.getConnection();
    }
}
