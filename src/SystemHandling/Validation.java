/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemHandling;

import GUIS.Notification;

/**
 *
 * @author BLiyanage
 */
public class Validation {
    //to display message in notification window
    Notification notif = new Notification();
    
    //check if Field is empty
    public void check(String type, String message){
        if(type.equals("")){
            //set error message
            notif.notifMess = message;
            
            notif.setVisible(true);
        }
    }
    
    public void notify(String message){
        notif.notifMess = message;
        notif.setVisible(true);
    }
}
