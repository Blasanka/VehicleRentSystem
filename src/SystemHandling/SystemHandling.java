/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemHandling;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;



public class SystemHandling {

    public DefaultTableModel model;
    
//vehicle member variables
    String vehicleNo;
    String vehicleName;
    String vehicleModel;
    String vehicleType;
    String vehicleColor;
    boolean airCondtion;
    boolean autoGear;
    double rentalPrice;
    double overDuePrice;
    double firstPayment;
    public void runClock(final JLabel label){
        
        new Thread(){
                public void run(){
                    while(true){
                        Calendar cal = new GregorianCalendar();
                        
                        int hours = cal.get(Calendar.HOUR);
                        int minute = cal.get(Calendar.MINUTE);
                        int second = cal.get(Calendar.SECOND);
                        int ap = cal.get(Calendar.AM_PM);
                        
                        String amVSpm;
                        if(ap == 0){
                            amVSpm = "AM";
                        }else{
                            amVSpm = "PM";
                        }
                        
                        String timer = hours + "-" + minute + "-" + second + " " +amVSpm;
                        
                        label.setText(timer);
                    }
                }
        }.start();
        
    }
    
    public void runDate(final JLabel label){
        
        new Thread(){
                public void run(){
                    Calendar cal = new GregorianCalendar();

                    int year = cal.get(Calendar.YEAR);
                    int month = cal.get(Calendar.MONTH);
                    int date = cal.get(Calendar.DATE);
                    int day = cal.get(Calendar.DAY_OF_WEEK);
                    
                    String dayWord;
                    
                    switch(day){
                        case 1:
                            dayWord = "Sunday";
                            break;
                        case 2:
                            dayWord = "Monday";
                            break;
                        case 3:
                            dayWord = "Tuesday";
                            break;
                        case 4:
                            dayWord = "Wednesday";
                            break;
                        case 5:
                            dayWord = "Thursday";
                            break;
                        case 6:
                            dayWord = "Friday";
                            break;
                        case 7:
                            dayWord = "Saturday";
                            break;
                        default:
                            dayWord = "";
                    }

                    String disDate = year + "-" + month + "-" + date + " " +dayWord;

                    label.setText(disDate);
                }
        }.start();
        
    }
    
    //get text
    String text;
    public String getText(String s){
        return s;
    }
    
    public void setText(String s){
        this.text = s;
    }
    
    public void changeMouseCursor(JLabel label, MouseEvent evt){
        //System.out.println(evt.getID());
        if(evt.getID() == 504){
            label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }else{
            label.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }
    
    public void changeForeground(JLabel label, MouseEvent evt){
        if(evt.getID() == 504){
            label.setForeground(Color.GRAY);
        }else{
            label.setForeground(Color.WHITE);
        }
    }
    
    public void changeForeground(JLabel label, MouseEvent evt, boolean section){
        if(evt.getID() == 504){
            label.setForeground(Color.GRAY);
        }else{
            label.setForeground(Color.BLACK);
        }
    }
}
