package soap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utilities.DatabaseConnection;

import utilities.ResultSetConverter;

// The DAO is a design pattern that separates data persistence logic from the business logic of an application 
// by providing an abstraction layer between the application and the data source. It encapsulates data access 
// logic in a separate object, provides methods for CRUD operations on data objects, and is used where the data source 
// may frequently change.
/**
 * This class provides a getElement() method that retrieves an element from the
 * database by ID and returns it as an object. The method uses a
 * PreparedStatement to prevent SQL injection attacks.
 *
 * @author API Project Group
 *
 */
public class ElementDAO {

    private Connection conn;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    private Element element = null;

    public ElementDAO() throws SQLException {
        conn = DatabaseConnection.getConnection();
    }

    public Element getElement(int idCol, String sizeCol) {
        try {
            if (conn == null) {
                throw new SQLException("Failed to obtain a connection from the pool.");
            }
            String sql = "SELECT " + sizeCol + " FROM elements WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idCol);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return ResultSetConverter.convertResultSetToElement(rs, sizeCol);

            }
        } catch (SQLException e) {
            // Handle the SQLException
            e.printStackTrace();
        } finally {
            // Close the database resources
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return element;
    }
}
