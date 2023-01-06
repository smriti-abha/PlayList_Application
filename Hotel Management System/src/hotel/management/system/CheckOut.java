
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.Date;


public class CheckOut extends JFrame implements ActionListener{
    JLabel text,lblid,lblroom,lblroomnumber, lblcheckintime, lblcheckin, lblcheckouttime, lblcheckout;
    Choice ccustomer;
    JButton checkout,back;
    CheckOut(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
         text = new JLabel("CheckOut");
         text.setBounds(100,20,100,30);
         text.setForeground(Color.BLUE);
         text.setFont(new Font("Tahoma",Font.PLAIN,20));
         add(text);
         
         lblid = new JLabel("Customer Id");
         lblid.setBounds(30,80,100,30);
         add(lblid);
         
          ccustomer=new Choice();
        ccustomer.setBounds(150,80,150,25);
        add(ccustomer);
        
        try{
          Conn conn= new Conn();
          ResultSet rs= conn.s.executeQuery("select * from customer");
          while(rs.next()){
            ccustomer.add(rs.getString("number"));
            lblroomnumber.setText(rs.getString("room"));
            lblcheckintime.setText(rs.getString("checkin_time"));
            
          }
        }catch(Exception e){
            e.printStackTrace();
        }
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("tick.png"));
       Image i2=i1.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(310,80,20,20);
       add(image);
       
        lblroom = new JLabel("Customer Id");
         lblroom.setBounds(30,130,100,30);
         add(lblroom);
         
         lblroomnumber = new JLabel();
         lblroomnumber.setBounds(150,130,100,30);
         add(lblroomnumber);
         
         
          lblcheckin = new JLabel("CheckIn Time");
          lblcheckin.setBounds(30,180,100,30);
         add( lblcheckin);
         
         lblcheckintime = new JLabel();
          lblcheckintime.setBounds(150,180,100,30);
         add( lblcheckintime);
         
          lblcheckout = new JLabel("CheckOut Time");
          lblcheckout.setBounds(30,230,100,30);
         add( lblcheckout);
         
         Date date = new Date();
         
         
         lblcheckouttime = new JLabel(""+date);
          lblcheckouttime.setBounds(150,230,150,30);
         add( lblcheckouttime);
         
         checkout= new JButton("Checkout");
         checkout.setBackground(Color.BLACK);
         checkout.setForeground(Color.CYAN);
         checkout.setBounds(30,280,120,30);
         checkout.addActionListener(this);
         add(checkout);
         
         back= new JButton("Back");
          back.setBackground(Color.BLACK);
          back.setForeground(Color.CYAN);
          back.setBounds(170,280,120,30);
           back.addActionListener(this);
         add( back);
         
          try{
          Conn conn= new Conn();
          ResultSet rs= conn.s.executeQuery("select * from customer");
          while(rs.next()){
            ccustomer.add(rs.getString("number"));
            lblroomnumber.setText(rs.getString("room"));
            lblcheckintime.setText(rs.getString("checkin_time"));
            
          }
        }catch(Exception e){
            e.printStackTrace();
        }
         
         ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("sixth.jpg"));
       Image i5=i1.getImage().getScaledInstance(400, 250,Image.SCALE_DEFAULT);
       ImageIcon i6 = new ImageIcon(i2);
       JLabel i7 = new JLabel(i6);
       i7.setBounds(350,50,400,250);
       add(i7);
         
        setBounds(300,200,800,400);
        setVisible(true);
        }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkout){
            String query1="delete from customer where number = '"+ccustomer.getSelectedItem()+"'";
            String query2="update room set availability = 'Available' where roomnumber='"+lblroomnumber.getText()+"'";
        try{
          Conn c= new Conn();
           c.s.executeUpdate(query1);
          c.s.executeUpdate(query2);
          
          JOptionPane.showMessageDialog(null," Checkout Done");
          setVisible(false);
            new Reception();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        }else{
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String [] args){
        new CheckOut();
    }
}
