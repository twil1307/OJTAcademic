/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package context;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author toten
 */
public class DBContext {

    public Connection getConnection() throws SQLException, ClassNotFoundException {

        Properties props = new Properties();
        try {
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("./Properties/charity.properties");
            props.load(is);
        } catch (IOException e) {
            // handle the exception
        }
        
        String serverName = props.getProperty("app.property.serverName");
        String dbName = props.getProperty("app.property.dbName");
        String portNumber = props.getProperty("app.property.portNumber");
        String userID = props.getProperty("app.property.userID");
        String password = props.getProperty("app.property.password");
        

        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        return DriverManager.getConnection(url, userID, password);
    }

//    private final String serverName = "LEDUC\\MAYAO";
//    private final String dbName = "ShoppingOnline2";
//    private final String portNumber = "1433";
//    private final String userID = "sa";
//    private final String password = "13072002";

    public static void main(String[] args) {
        try {
            Connection connection = new DBContext().getConnection();
            
            if (connection != null) {
                System.out.println("Connect successfully to dtb");
            } else {
                System.out.println("Connect failed");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
