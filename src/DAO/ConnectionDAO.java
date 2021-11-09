/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author jasib
 */
public class ConnectionDAO {
    
    public Connection conectaBD() {
        
        Connection conn = null;
        
        try {
            
            String url = "jdbc:mysql://remotemysql.com:3306/pyrftFX7oV?user=pyrftFX7oV&password=brhALA80Ht";
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Connection: " + e.getMessage());
        }
        
        return conn;
    }
}
