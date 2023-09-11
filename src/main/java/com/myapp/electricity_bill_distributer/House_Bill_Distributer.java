package com.myapp.electricity_bill_distributer;
import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;

public class House_Bill_Distributer {
    JFrame frame;
    protected void calculateAmount(float u1, float u2, float amtHb, float pu1, float pu2){
        frame = new JFrame();
        frame.setSize(300,300);
        float act1 = Math.abs(u1-pu1);
        float act2 = Math.abs(u2-pu2);
        float h1amt = (act1*amtHb)/(act1+act2);
        float h2amt = Math.abs(amtHb - h1amt);
        JOptionPane.showMessageDialog(frame,"Total Amount : "+Math.round(amtHb)+"\n\nAmount of House 1 : "+Math.round(h1amt)+"\n\nAmount of House 2 : "+Math.round(h2amt));
        try{
            Date d= new Date();
            String date = String.valueOf(d.getDate());
            String month = String.valueOf(d.getMonth());
            String year = String.valueOf(d.getYear());
            File f = new File("D:\\HouseBill.txt");
            FileWriter fw = new FileWriter(f,true);
            String famt = String.valueOf(Math.round(amtHb));
            String fprevh1 = String.valueOf(Math.round(pu1));
            String fprevh2 = String.valueOf(Math.round(pu2));
            String fcurh1 = String.valueOf(Math.round(u1));
            String fcurh2 = String.valueOf(Math.round(u2));
            String fh1 = String.valueOf(Math.round(h1amt));
            String fh2 = String.valueOf(Math.round(h2amt));
            fw.write("Date: "+date+"/"+month+"/"+year+"\n\nTotal Amount: "+famt+"\nCurrent Unit of House 1: "+fcurh1+"\nPrevious Unit of House 1: "+fprevh1+"\nCurrent Unit of House 2: "+fcurh2+"\nPrevious Unit of House 2: "+fprevh2+"\nAmount of House 1: "+fh1+"\nAmount of House 2: "+fh2+"\n\n\n");
            fw.close();
            JOptionPane.showMessageDialog(frame,"Data Saved in D: Drive");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(frame,"Failed to Save the File");
        }
        frame.dispose();
    }

    protected void error(){
        JOptionPane.showMessageDialog(frame, "Error!! Check The input");
    }
}
