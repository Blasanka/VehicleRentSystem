/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemHandling;

import javax.swing.JPanel;

/**
 *
 * This class handle the panel switches in Main window
 */
public class PanelsHandling extends JPanel{
    //remove previous panel
    public void removePanels(JPanel area){
        area.removeAll();
        area.repaint();
        area.revalidate();
    }
    
    //remove previous panel oveload method
    public void removePanels(JPanel area, JPanel childArea){
        area.removeAll();
        area.repaint();
        area.revalidate();
        
        childArea.removeAll();
        childArea.repaint();
        childArea.revalidate();
    }
    
    //add panel to main form
    public void addPanels(JPanel area,  JPanel childArea){
        area.add(childArea);
        area.repaint();
        area.revalidate();
    }
    
    //add panel oveload method
    public void addPanels(JPanel area){
        area.add(area);
        area.repaint();
        area.revalidate();
    }
    
    
    /*
    
    addNRemovePanels() to handle panels handle in above methods these below method
    reduce calling the same methods in variace mouseClick listener methods.
    
    */
    
    
    //Get all methods to one method to avoid redundance
    //no selectionArea and selectionCategory
    //no grandChildArea
    public void addNRemovePanels(JPanel parentArea, JPanel grandChildArea){
        //remove workAreaPanel
        removePanels(parentArea);
        
        //add recieveARentedVehiclePanel to workAreaPanele
        addPanels(parentArea, grandChildArea);
    }
    
    //Get all methods to one method to avoid redundance
    //no selectionArea and selectionCategory
    public void addNRemovePanels(JPanel parentArea, JPanel childArea, JPanel grandChildArea){
        //remove workAreaPanel
        //remove RentsCategoryPanel
        removePanels(parentArea, childArea);
        
        //add RentsCategoryPanel to workAreaPanel
        addPanels(parentArea, childArea);
        
        //add RentAVehiclePanel to RentsCategoryPanel
        addPanels(childArea, grandChildArea);
    }
    
    //Get all methods to one method to avoid redundance
    //to for panels without grandChildArea
    public void addNRemovePanels(JPanel parentArea, JPanel selectionArea, JPanel selectionCategory, JPanel childArea){
        //remove selectionArea
        removePanels(selectionArea);
        
        //add RentsSelection to selectionArea
        addPanels(selectionArea, selectionCategory);
        
        //remove workAreaPanel using panel instance
        removePanels(parentArea);
        
        //add RentsCategoryPanel to workAreaPanel
        addPanels(parentArea, childArea);
    }
    
    //Get all methods to one to avoid redundance
    public void addNRemovePanels(JPanel parentArea, JPanel selectionArea, JPanel selectionCategory,
            JPanel childArea, JPanel grandChildArea){
        
        //remove selectionArea
        removePanels(selectionArea);
        
        //add vehicleSelection to selectionArea
        addPanels(selectionArea, selectionCategory);
        
        //remove workAreaPanel
        //remove VehicleCategoryPanel
        removePanels(parentArea, childArea);
        
        //add VehicleCategoryPanel to workAreaPanel
        addPanels(parentArea, childArea);
        
        //add VehicleCategoryPanel to viewVehiclePanel
        addPanels(childArea, grandChildArea);
    }
}
