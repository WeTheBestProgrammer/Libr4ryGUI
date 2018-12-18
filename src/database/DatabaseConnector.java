/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;

/**
 *
 * @author KINTUL
 */
public class DatabaseConnector {
    private Connection databaseConnection = null;

    public DatabaseConnector(String url, String user, String password) throws SQLException {
        databaseConnection = DriverManager.getConnection("jdbc:mysql://localhost/perpustakaan", "root", "");
    }
    
    public void close() throws SQLException {
        databaseConnection.close();
    }

    
    
}
