
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class UpdateCheck extends JFrame implements ActionListener{
    JLabel text,lblid,lblroom,lblname,lblcheckin, lblpaid, lblpending;
    Choice ccustomer;
    JTextField tfroom,tfname,tfcheckin, tfpaid,tfpending;
    JButton check,update, back;
    
    UpdateCheck(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        text= new JLabel("Update Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(90,20,200,30);
        text.setForeground(Color.BLUE);
        add(text);
        
        lblid= new JLabel("Customer Id");
         lblid.setBounds(30,80,100,20);
       add(lblid);
       
        ccustomer=new Choice();
        ccustomer.setBounds(200,80,150,25);
        add(ccustomer);
        
        try{
          Conn conn= new Conn();
          ResultSet rs= conn.s.executeQuery("select * from customer");
          while(rs.next()){
            ccustomer.add(rs.getString("number"));
            
          }
        }catch(Exception e){
            e.printStackTrace();
        }
        
         lblroom= new JLabel("Room Number");
         lblroom.setBounds(30,120,100,20);
       add(lblroom);
       
       tfroom= new JTextField();
       tfroom.setBounds(200,120,150,25);
       add(tfroom);
       
        lblname= new JLabel("Name");
         lblname.setBounds(30,160,100,20);
       add(lblname);
       
       tfname= new JTextField();
       tfname.setBounds(200,160,150,25);
       add(tfname);
       
       lblcheckin= new JLabel("CheckIn Time");
         lblcheckin.setBounds(30,200,100,20);
       add(lblcheckin);
       
      tfcheckin= new JTextField();
       tfcheckin.setBounds(200,200,150,25);
       add( tfcheckin);
       
       lblpaid= new JLabel("Amount Paid");
          lblpaid.setBounds(30,240,100,20);
       add( lblpaid);
       
       tfpaid= new JTextField();
       tfpaid.setBounds(200,240,150,25);
       add(tfpaid);
       
        lblpending= new JLabel("Pending Amount");
          lblpending.setBounds(30,280,100,20);
       add( lblpending);
       
       tfpending = new JTextField();
       tfpending.setBounds(200,280,150,25);
       add(tfpending);
       
       check = new JButton("Check");
       check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30,340,100,30);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(150,340,100,30);
        update.addActionListener(this);
        add(update);
        
       back = new JButton("Back");
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.setBounds(270,340,100,30);
       back.addActionListener(this);
       add(back);
       
       ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("nine.jpg"));
       JLabel image= new JLabel(i1);
       image.setBounds(400,50,500,300);
       add(image);
       
        setBounds(300,200,980,500);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==check){
            String id=ccustomer.getSelectedItem();
            String str= "select * from customer where number = '"+id+"'";
//            String checkin_time=tfcheckin.getText();
//            String checkin_time = "select * customer where checkin_time='"+checkin_time+"'";
           try{
              Conn c= new Conn(); 
              ResultSet rs = c.s.executeQuery(str);
              while(rs.next()){
                  tfroom.setText(rs.getString("room"));
                  tfname.setText(rs.getString(("name")));
                  tfcheckin.setText(rs.getString("checkin_time"));
                  tfpaid.setText(rs.getString("deposit"));
              }
              ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber='"+tfroom.getText()+"'");
               while(rs2.next()){
               String price = rs2.getString("price");
               int amountPaid = Integer.parseInt(price)-Integer.parseInt(tfpaid.getText());
               tfpending.setText(""+amountPaid);
               }
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==update){
           String number = ccustomer.getSelectedItem();
           String room= tfroom.getText();
           String name=tfname.getText();
           String checkin=tfcheckin.getText();
           String deposit= tfpaid.getText();
           try{
              Conn c= new Conn();
    c.s.executeUpdate("update customer set room='"+room+"', name='"+name+"', checkin_time='"+checkin+"', deposit='"+deposit+"'where number='"+number+"'");
    
          JOptionPane.showMessageDialog(null,"Data Updated Successfully");
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
        new UpdateCheck();
    }
}
