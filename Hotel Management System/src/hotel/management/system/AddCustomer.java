
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener {
    
    JComboBox comboid;
    JTextField tfnumber,tfname,tfcountry,tfdeposit;
    JRadioButton rmale,rfemale;
    Choice croom;
    JLabel checkintime,text,lblid,lblnumber,lblname,lblgender,lblcountry,lblroom,lbltime,lbldeposit;
    JButton add,back;
    
    AddCustomer(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null); 
        
         text = new JLabel("New Customer Form");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("RaleWay",Font.PLAIN,20));
       add(text);
       
         lblid = new JLabel("ID");
        lblid.setBounds(35,80,100,20);
        lblid.setFont(new Font("Tahoma",Font.PLAIN,20));
       add(lblid);
       
       String options[] = {"Aadhar Card"," Driving License", "PassPort","Pan Card"," Voter ID card","Rasan Card"};
       comboid= new JComboBox(options);
       comboid.setBounds(200,80,150,25);
       comboid.setBackground(Color.cyan);
       add(comboid);
       
        lblnumber = new JLabel("Number");
        lblnumber.setBounds(35,120,100,20);
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,20));
       add(lblnumber);
       
       tfnumber= new JTextField();
       tfnumber.setBounds(200,120,150,25);
       add(tfnumber);
       
         lblname = new JLabel("Name");
        lblname.setBounds(35,160,100,20);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,20));
       add(lblname);
       
      tfname= new JTextField();
       tfname.setBounds(200,160,150,25);
       add(tfname);
       
         lblgender= new JLabel("Gender");
     lblgender.setBounds(35,200,100,20);
     lblgender.setFont(new Font("Tahoma",Font.PLAIN,17));
     add(lblgender);
     
     rmale = new JRadioButton("Male");
      rmale.setBackground(Color.WHITE);
     rmale.setBounds(200,200,60,25);
    add(rmale);
     
       rfemale = new JRadioButton("Female");
        rfemale.setBackground(Color.WHITE);
     rfemale.setBounds(270,200,100,25);
  add(rfemale);
     
     
       lblcountry= new JLabel("Country");
     lblcountry.setBounds(35,240,100,20);
     lblcountry.setFont(new Font("Tahoma",Font.PLAIN,17));
     add(lblcountry);
     
     tfcountry= new JTextField();
       tfcountry.setBounds(200,240,150,25);
       add(tfcountry);
       
         lblroom= new JLabel("Room Number");
     lblroom.setBounds(35,280,150,20);
     lblroom.setFont(new Font("Tahoma",Font.PLAIN,17));
     add(lblroom);
     
     croom= new Choice();
    
     try{
      Conn conn= new Conn(); // for generated connection with mysql
      String query = "select * from room ";
      
      ResultSet rs = conn.s.executeQuery(query);
      while(rs.next()){
          croom.add(rs.getString("roomnumber"));
      }
     }
     catch(Exception e){
         
         e.printStackTrace();
     }
     croom.setBounds(200, 280, 150, 25);
     add(croom);
     
      lbltime = new JLabel("Checkin time");
     lbltime.setBounds(35,320,150,20);
     lbltime.setFont(new Font("Tahoma",Font.PLAIN,17));
     add(lbltime);
     
     Date date = new Date();
     
     checkintime = new JLabel(""+ date);
     checkintime.setBounds(200,320,150,25);
     checkintime.setFont(new Font("Tahoma",Font.PLAIN,16));
     add(checkintime);
     
       lbldeposit= new JLabel("Deposit");
     lbldeposit.setBounds(35,360,100,20);
     lbldeposit.setFont(new Font("Tahoma",Font.PLAIN,17));
     add(lbldeposit);
     
     tfdeposit= new JTextField();
       tfdeposit.setBounds(200,360,150,25);
       add(tfdeposit);
       
       add = new JButton("Add");
       add.setBackground(Color.BLACK);
       add.setForeground(Color.WHITE);
       add.setBounds(50,410,120,30);
       add.addActionListener(this);
       add(add);
       
       back = new JButton("Back");
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.setBounds(200,410,120,30);
       back.addActionListener(this);
       add(back);
       
       ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("fifth.png"));
       Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(400,50,300,400);
       add(image);
       
       
        setBounds(350,200,800,550);
//        setBackground(Color.WHITE);
//        setForeground(Color.BLACK);
        setVisible(true);
    }
    public void actionPerformed (ActionEvent ae){
      if(ae.getSource()==add){
          String document = (String) comboid.getSelectedItem();
          String number = tfnumber.getText();
          String name=tfname.getText();
          String gender= null;
          if(rmale.isSelected()){
              gender="Male";
          }else{
              gender="Female";
          }
          String country= tfcountry.getText();
          String roomnumber=croom.getSelectedItem();
          String checkin_time = checkintime.getText();
          String deposit= tfdeposit.getText();
          try{
            
 String query = "insert into customer values('"+document+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+roomnumber+"', '"+checkin_time+"', '"+deposit+"')";
            
    String query2 = "update room set availability = 'Occupied' where roomnumber = '"+roomnumber+"'";
            Conn conn = new Conn();
            conn.s.executeUpdate(query);
             conn.s.executeUpdate(query2);
             
             JOptionPane.showMessageDialog(null,"New Customer Added Successfully");
             setVisible(false);
              new Reception();
              
              
              
          }catch(Exception e){
            e.printStackTrace();  
          }
      } else if(ae.getSource()==back)
      {
        setVisible(false);
              new Reception();  
      }
    }
    public static void main(String [] args){
        new AddCustomer();
    }
}
