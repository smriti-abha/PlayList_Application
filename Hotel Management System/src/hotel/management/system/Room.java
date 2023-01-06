
package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Room extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    JLabel l1,l2,l3,l4,l5,l6;
    Room(){
      getContentPane().setBackground(Color.WHITE);
      setLayout(null);
      
      ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("eight.jpg"));
      Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
      ImageIcon i3= new ImageIcon(i2);
      JLabel image = new JLabel(i3);
      image.setBounds(600,0,600,600);
      add(image);
      
      l1 = new JLabel("Room Number");
      l1.setBounds(10,10,100,20);
      add(l1);
      
       l2= new JLabel("Availability");
     l2.setBounds(120,10,100,20);
      add(l2);
      
     l3 = new JLabel("Status");
      l3.setBounds(230,10,100,20);
      add(l3);
      
        l4 = new JLabel("Price");
      l4.setBounds(330,10,100,20);
      add(l4);
      
      l5 = new JLabel("Deposit");
      l5.setBounds(410,10,100,20);
      add(l5);
      
       l6 = new JLabel("Bed Type");
      l6.setBounds(500,10,100,20);
      add(l6);
      
      table = new JTable();
      table.setBounds(0,40,500,400);
      add(table);
      
      
      
      try{
      Conn conn= new Conn();
      ResultSet rs = conn.s.executeQuery("select * from room");
      table.setModel(DbUtils.resultSetToTableModel(rs));
      
      
      
      }
      catch(Exception e){
         e.printStackTrace(); 
      }
      
      back = new JButton("Back");
    back.setBackground(Color.BLACK);
          back.setForeground(Color.WHITE);
         back.setBounds(200,500,120,30);
          back.addActionListener(this);
          add(back);
          
      
      setBounds(300,200,1050,600);
      setVisible(true);
      
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }

public static void main(String [] args){
    new Room();
}
}
