/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemHandling;

import Database.DB;
import GUIS.AddACustomer;
import GUIS.SearchCustomer;
import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CustomerHandling extends Person{
    //customer member variables
    public static int cusNo;
    private String cusName;
    private String cusLicenseNo;
    private String cusPhone;
    private String cusStatus;
    

//    public CustomerHandling(int cusNo, String cusName, String cusLicenseNo, int cusPhone, String cusStatus) {
//        this.cusNo = cusNo;
//        this.cusName = cusName;
//        this.cusLicenseNo = cusLicenseNo;
//        this.cusPhone = cusPhone;
//        this.cusStatus = cusStatus;
//    }

    public int getCusNo() {
        return cusNo;
    }

    public String getCusName() {
        return cusName;
    }

    public String getCusLicenseNo() {
        return cusLicenseNo;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public String getCusStatus() {
        return cusStatus;
    }

    public void setCusNo(int cusNo) {
        this.cusNo = cusNo;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public void setCusLicenseNo(String cusLicenseNo) {
        this.cusLicenseNo = cusLicenseNo;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public void setCusStatus(String cusStatus) {
        this.cusStatus = cusStatus;
    }
    
    public void checkACustomer(String s, JFrame frame){
        
        try {
            ResultSet rs = DB.getConnect().executeQuery("SELECT * FROM customer WHERE NIC = '"+s+"'");
            if(rs.last()){
                setCusNo(rs.getInt("cusId"));
                setCusName(rs.getString("name"));
                setCusLicenseNo(rs.getString("cus_license_no"));
                setCusPhone(rs.getString("phone1"));
                setCusStatus(rs.getString("cus_status"));
            }else{
                int yes = JOptionPane.showConfirmDialog(null, "No Customer found, Do you want to add a new customer?");
                if(yes == 0){
                    frame.dispose();
                
                    //all opened frame to a array
                    Frame[] activeFrames = Frame.getFrames();
                    //Iterate through the activeFrames array
                    for(Frame fr : activeFrames){
                        //to get specific frame name
                        String specificFrameName = fr.getClass().getName();
                        //if found frame that I want I can close or any you want
                        if(specificFrameName.equals("GUIS.CheckForCustomer")){
                            fr.dispose();
                        }
                    }
                    new AddACustomer().setVisible(true);
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
