/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author BLiyanage
 */
public class DB {
    public static Statement getConnect() throws SQLException{
        Statement st = getCon().createStatement();
        return st;
    }
    
    public static Connection getCon(){
        Connection con = null;
        try{
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehiclerentsystem","root","1234");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Database failed! talk to developer");
        }
        return con;
    }
}
