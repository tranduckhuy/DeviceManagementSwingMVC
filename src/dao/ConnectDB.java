
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class ConnectDB {

    protected ConnectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    protected Connection getConnection() {
        Connection conn;
        try {
            String user = "root";
            String password = "duchuy2003";
            String URL = "jdbc:mysql://localhost:3306/connectdb";
            conn = DriverManager.getConnection(URL, user, password);
            if(conn != null) {
                return conn;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
}
