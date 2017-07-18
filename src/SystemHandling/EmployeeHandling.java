/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemHandling;

import Database.DB;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EmployeeHandling extends Person{
    String empStatus;
    
//    java.sql.Date birthYear;
//    java.util.Date birth;
    
    DefaultTableModel tableModel;
    
    public void getTableValues(JTable table){
        try {
            ResultSet result = DB.getConnect().executeQuery("SELECT * FROM employee");
            while(result.next()){
                id = result.getInt("empId");
                name = result.getString("name");
                NIC = result.getString("NIC");
                address = result.getString("address");
                phone1 = result.getInt("phone1");
                phone2 = result.getInt("phone2");
                email = result.getString("email");
                empStatus = result.getString("emp_status");
                
//                birthYear = result.getDate("birthyear");
//                birth = new java.util.Date(birthYear.getDate());
                
                tableModel = (DefaultTableModel) table.getModel();
                tableModel.addRow(new Object[]{id, name, NIC, phone1, phone2, 
                address, email, empStatus});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void add(String name, String nic, String address, String p1, String p2, String mail, String state){
        //this.id = Integer.parseInt(no);
        this.phone1 = Integer.parseInt(p1);
        this.phone2 = Integer.parseInt(p2);
        this.name = name;
        this.address = address;
        this.NIC = nic;
        this.email = mail;
        this.empStatus = state;
        
        try {
            DB.getConnect().executeUpdate("INSERT INTO employee(name,NIC,address,phone1,phone2,email,emp_status) VALUES('"+this.name+"', '"+this.NIC+"', '"+this.address+"', '"+this.phone1+"', '"+this.phone2+"', '"+this.email+"','"+this.empStatus+"')");
            JOptionPane.showMessageDialog(null, "Successfully added!");
        }catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Can not add this employee");
        }
    }
    
    public String[] search(String s){
        //assign id from searched emp no to update this specific row
        this.id = Integer.parseInt(s);
        //create array to send employee detalis to update
        String list[] = new String[5];
        try {
            //get emp details that want to update
            ResultSet rs = DB.getConnect().executeQuery("SELECT name,address, phone1, phone2, email FROM employee WHERE empId = '"+s+"'");
            if(rs.last()){
                list[0] = rs.getString("name");
                list[1] = rs.getString("address");
                list[2] = rs.getString("phone1");
                list[3] = rs.getString("phone2");
                list[4] = rs.getString("email");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No employee for searched Employee No");
        }
        //return table column value through array
        return list;
    }
    
    public void update(String name, String address, String p1, String p2, String mail){
        //this.id = Integer.parseInt(no);
        try{
        this.phone1 = Integer.parseInt(p1);
        this.phone2 = Integer.parseInt(p2);
        }catch(NumberFormatException e){
            e.printStackTrace();
        }
        
        try {
            //take searched emp no and update that specific row
            DB.getConnect().executeUpdate("UPDATE employee SET name = '"+name+"' WHERE empId = '"+this.id+"'");
            DB.getConnect().executeUpdate("UPDATE employee SET address = '"+address+"' WHERE empId = '"+this.id+"'");
            DB.getConnect().executeUpdate("UPDATE employee SET phone1 = '"+phone1+"' WHERE empId = '"+this.id+"'");
            DB.getConnect().executeUpdate("UPDATE employee SET phone2 = '"+phone2+"' WHERE empId = '"+this.id+"'");
            DB.getConnect().executeUpdate("UPDATE employee SET email = '"+email+"' WHERE empId = '"+this.id+"'");
            JOptionPane.showMessageDialog(null, "Successfully Updated!");
        }catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Can not update this employee details");
        }
    }
}
