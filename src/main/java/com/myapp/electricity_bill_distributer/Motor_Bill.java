package com.myapp.electricity_bill_distributer;
import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;

public class Motor_Bill {
    JFrame frame;
    protected void calculateAmount(float prevUnit,float currUnit,float totUnit ,float totAmt,float ghar){
        frame = new JFrame();
        frame.setSize(300,300);
        float amtCalc = currUnit - prevUnit;
        float actualAmt = (amtCalc * totAmt)/ totUnit;
        float gharDis = actualAmt/ghar;
        JOptionPane.showMessageDialog(frame,"Total Amount: "+Math.abs(Math.round(totAmt)) +"\nPrevious Motor Unit: "+Math.abs(Math.round(prevUnit))+"\nCurrent Motor Unit: "+Math.abs(Math.round(currUnit))+"\nTotal Electric Unit in Bill: "+Math.abs(Math.round(totUnit))+"\n\nAmount Generated for Motor: "+Math.abs(Math.round(actualAmt))+"\nAmount per House: "+ Math.abs(Math.round(gharDis)));
        try {
            Date d= new Date();
            String date = String.valueOf(d.getDate());
            String month = String.valueOf(d.getMonth());
            String year = String.valueOf(d.getYear());
            File f = new File("D:\\MotorBill.txt");
            FileWriter fw = new FileWriter(f,true);
            String a1 = String.valueOf(Math.abs(Math.round(totAmt)));
            String a2 = String.valueOf(Math.abs(Math.round(prevUnit)));
            String a3 = String.valueOf(Math.abs(Math.round(currUnit)));
            String a4 = String.valueOf(Math.abs(Math.round(totUnit)));
            String a5 = String.valueOf(Math.abs(Math.round(actualAmt)));
            String a6 = String.valueOf(Math.abs(Math.round(gharDis)));
            fw.write("Date: "+date+"/"+month+"/"+year+"\n\nTotal Amount: "+a1+"\nPrevious Motor Unit: "+a2+"\nCurrent Motor Unit: "+a3+"\nTotal Electric Unit in Bill: "+a4+"\nAmount Generated for Motor: "+a5+"\nAmount per House: "+a6+"\n\n\n");
            fw.close();
            JOptionPane.showMessageDialog(frame,"Data Saved in D: Drive");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(frame,"Failed To Save The File");
        }
        frame.dispose();
    }

    protected void error(){
        JOptionPane.showMessageDialog(frame, "Error!! Check The input");
    }
}
