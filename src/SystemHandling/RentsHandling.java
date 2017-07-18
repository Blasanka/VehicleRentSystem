/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemHandling;

import Database.DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BLiyanage
 */
public class RentsHandling extends SystemHandling{
    
    public void getOnHandVehicles(JTable table)throws SQLException{
        //get the values in onHandVehicles view that created joining three tables to show in 'rents category' table 
        ResultSet rs = DB.getConnect().executeQuery("SELECT * FROM onHandVehicles");
        while(rs.next()){
            vehicleNo = rs.getString("VehicleLicenseNo");
            vehicleName = rs.getString("name");
            vehicleModel = rs.getString("name");
            vehicleType = rs.getString("type");
            vehicleColor = rs.getString("color");
            rentalPrice = rs.getDouble("rental_price");
            airCondtion = rs.getBoolean("AirCondition");
            autoGear = rs.getBoolean("autoGear");
            overDuePrice = rs.getDouble("overdue_price");
            firstPayment = rs.getDouble("first_payment");
            
            //Add onhand vehicle details to rent a vehicle jTable
            model = (DefaultTableModel) table.getModel();
            model.addRow(new Object[]{vehicleNo, vehicleType, vehicleName, vehicleModel, vehicleColor, 
                airCondtion ? "Yes" : "No", autoGear ? "Yes" : "No", rentalPrice, overDuePrice, firstPayment});
            
        }
    }
    
    public void getOnHandVehicles(JTable table, String s)throws SQLException{
        //get the values in onHandVehicles view that created joining three tables to show in 'rents category' table 
        ResultSet rs = DB.getConnect().executeQuery("SELECT * FROM onHandVehicles WHERE name LIKE '%"+s+"%' OR type = '"+s+"' OR model='"+s+"'");
        //if no vehicles found related to search
        if(!rs.isBeforeFirst()){
            //new Validation().notify("No vehicle found!");
            JOptionPane.showMessageDialog(null, "No vehicle found!");
        }
        while(rs.next()){
            vehicleNo = rs.getString("VehicleLicenseNo");
            vehicleName = rs.getString("name");
            vehicleModel = rs.getString("name");
            vehicleType = rs.getString("type");
            vehicleColor = rs.getString("color");
            rentalPrice = rs.getDouble("rental_price");
            airCondtion = rs.getBoolean("AirCondition");
            autoGear = rs.getBoolean("autoGear");
            overDuePrice = rs.getDouble("overdue_price");
            
            //Add onhand vehicle details to rent a vehicle jTable
            model = (DefaultTableModel) table.getModel();
            model.addRow(new Object[]{vehicleNo, vehicleType, vehicleName, vehicleModel, vehicleColor, 
                airCondtion ? "Yes" : "No", autoGear ? "Yes" : "No", rentalPrice, overDuePrice});
            
        }
    }
    
    public void getRentedVehicles(JTable table)throws SQLException{
        //get the values in onHandVehicles view that created joining three tables to show in 'rents category' table 
        ResultSet rs = DB.getConnect().executeQuery("SELECT * FROM vehicle WHERE onhand = '"+0+"'");
        while(rs.next()){
            vehicleNo = rs.getString("VehicleLicenseNo");
            vehicleName = rs.getString("name");
            vehicleModel = rs.getString("name");
            vehicleType = rs.getString("type");
            vehicleColor = rs.getString("color");
            airCondtion = rs.getBoolean("AirCondition");
            autoGear = rs.getBoolean("autoGear");
            
            //Add onhand vehicle details to rent a vehicle jTable
            model = (DefaultTableModel) table.getModel();
            model.addRow(new Object[]{vehicleNo, vehicleType, vehicleName, vehicleModel, vehicleColor, 
                airCondtion ? "Yes" : "No", autoGear ? "Yes" : "No"});
            
        }
    }
    
    public void rentAVehicle(){
        
    }
    
    public void viewOnHandRents(){
        
    }
    Vector v = new Vector();
    public void setSelectedRow(Vector row){
        //vehicleNo = row.get(0)+"";
        //vehicleName = row.get(1)+"";
        //vehicleType = row.get(2)+"";
        //System.out.println(row);
        v.add(row);
    }
    
    public void getSelectedRow(Vector row){
        //vehicleNo = row.get(0)+"";
        //vehicleName = row.get(1)+"";
        //vehicleType = row.get(2)+"";
        System.out.println(v.get(0));
        
    }
}
