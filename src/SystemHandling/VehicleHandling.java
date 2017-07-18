/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemHandling;

import Database.DB;
import GUIS.Main;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VehicleHandling extends SystemHandling {
    String vehicleRegisteredRegion;
    String regCountry;
    String manufacturer;
    String manuCountry;
    String insuranceNo;

    public void viewAllVehicles(JTable table) throws SQLException {
        ResultSet rs = DB.getConnect().executeQuery("SELECT * FROM Vehicle");
        while (rs.next()) {
            vehicleNo = rs.getString("VehicleLicenseNo");
            vehicleName = rs.getString("name");
            vehicleModel = rs.getString("name");
            vehicleType = rs.getString("type");
            vehicleColor = rs.getString("color");
            airCondtion = rs.getBoolean("AirCondition");
            autoGear = rs.getBoolean("autoGear");
            manufacturer = rs.getString("manufacture");
            manuCountry = rs.getString("manufactCountry");
            insuranceNo = rs.getString("insuraneNo");

            //Add onhand vehicle details to rent a vehicle jTable
            model = (DefaultTableModel) table.getModel();
            model.addRow(new Object[]{vehicleNo, vehicleType, vehicleName, vehicleModel, insuranceNo, vehicleColor,
                airCondtion ? "Yes" : "No", autoGear ? "Yes" : "No", manufacturer, manuCountry});

        }
    }
    
    public void addVehicle(){
        int air = airCondtion ? 1:0;
        int auto = autoGear ? 1:0;
        try {
            DB.getConnect().executeUpdate("INSERT INTO vehicle VALUES('"+vehicleNo+"',"
                    + " '"+vehicleName+"', '"+vehicleType+"','"+vehicleModel+"','"+insuranceNo+"','"+vehicleColor+"','"+air+"','"+auto+"','"+manufacturer+"',"
                    + "'"+manuCountry+"','"+regCountry+"','"+vehicleRegisteredRegion+"','"+1+"')");//1 because of when vehicle added it is onhand vehicle if 0, vehicle is rented
            JOptionPane.showMessageDialog(null, "vehicle Added");
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Can not add this vehicle!");
        }
        
    }
    
    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public void setInsuranceNo(String insuranceNo) {
        this.insuranceNo = insuranceNo;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public void setAirCondtion(boolean airCondtion) {
        this.airCondtion = airCondtion;
    }

    public void setAutoGear(boolean autoGear) {
        this.autoGear = autoGear;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setManuCountry(String manuCountry) {
        this.manuCountry = manuCountry;
    }

    public void setVehicleRegisteredRegion(String vehicleRegisteredRegion) {
        this.vehicleRegisteredRegion = vehicleRegisteredRegion;
    }

    public void setRegCountry(String regCountry) {
        this.regCountry = regCountry;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    
    public String getManufacturer() {
        return manufacturer;
    }

    public String getManuCountry() {
        return manuCountry;
    }

    public String getInsuranceNo() {
        return insuranceNo;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public boolean isAirCondtion() {
        return airCondtion;
    }

    public boolean isAutoGear() {
        return autoGear;
    }

    public String getVehicleRegisteredRegion() {
        return vehicleRegisteredRegion;
    }

    public String getRegCountry() {
        return regCountry;
    }

}
