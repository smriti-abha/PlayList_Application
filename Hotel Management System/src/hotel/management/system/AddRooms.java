
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class AddRooms extends JFrame implements ActionListener{
    JButton add , cancel;
    JTextField tfroom,tfprice;
    JComboBox typecombo,availablecombo,cleancombo;
    JLabel heading,lblroomno,lblavailable,lblclean,lblprice,lbltype;
  AddRooms(){
      
       getContentPane().setBackground(Color.WHITE);
      setLayout(null);
     
       heading = new JLabel("Add Rooms");
      heading.setFont(new Font("Tahoma", Font.PLAIN, 18));
      heading.setBounds(150,20,200,20);
      add(heading);
      
        lblroomno = new JLabel("Room Number");
      lblroomno.setFont(new Font("Tahoma", Font.BOLD, 16));
      lblroomno.setBounds(60,80,120,30);
      add(lblroomno);
      
       tfroom= new JTextField();
      tfroom.setBounds(200,80,150,30);
      add(tfroom);
      
         lblavailable = new JLabel("Available");
      lblavailable.setFont(new Font("Tahoma", Font.BOLD, 16));
      lblavailable.setBounds(60,130,120,30);
      add(lblavailable);
      
      String availableoptions []={"Available","Occupied"};
       availablecombo =new JComboBox(availableoptions);
      availablecombo.setBounds(200,130,150,30);
      availablecombo.setForeground(Color.WHITE);
      add(availablecombo);
      
       lblclean = new JLabel("Cleaning Status");
      lblclean.setFont(new Font("Tahoma", Font.BOLD, 16));
      lblclean.setBounds(60,180,120,30);
      add(lblclean);
      
      String cleanoptions []={"Cleaned","Dirty"};
      cleancombo =new JComboBox(cleanoptions);
     cleancombo.setBounds(200,180,150,30);
      cleancombo.setForeground(Color.WHITE);
      add(cleancombo);
      
       lblprice = new JLabel("Price");
      lblprice.setFont(new Font("Tahoma", Font.BOLD, 16));
      lblprice.setBounds(60,230,120,30);
      add(lblprice);
      
       tfprice= new JTextField();
      tfprice.setBounds(200,230,150,30);
      add(tfprice);
      
       lbltype = new JLabel("Bed Type");
     lbltype.setFont(new Font("Tahoma", Font.BOLD, 16));
     lbltype.setBounds(60,280,120,30);
      add(lbltype);
      
      String typeoptions []={"Single Bed","Double Bed"};
      typecombo =new JComboBox(typeoptions);
     typecombo.setBounds(200,280,150,30);
      typecombo.setForeground(Color.WHITE);
      add(typecombo);
      
       add = new JButton("Add Room");
      add.setForeground(Color.WHITE);
       add.setBackground(Color.BLACK);
       add.setBounds(60,350,130,30);
       add.addActionListener(this);
       add(add);
      
       cancel = new JButton("Cancel Room");
     cancel.setForeground(Color.WHITE);
      cancel.setBackground(Color.BLACK);
      cancel.setBounds(220,350,130,30);
       cancel.addActionListener(this);
       add(cancel);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("twelve.jpg"));
       JLabel image = new JLabel(i1);
       image.setBounds(400,30,500,300);
       add(image);
       
      
       setBounds(330,200,940,470);
     setVisible(true);
      
  } 
  public void actionPerformed(ActionEvent ae){
      
      if(ae.getSource()==add){
        String roomnumber=tfroom.getText();
        String availability = (String) availablecombo.getSelectedItem();
        String cleaning_status = (String) cleancombo.getSelectedItem();
         String price = tfprice.getText();
         String bed_type = (String) typecombo.getSelectedItem();
         
         try{
           Conn conn = new Conn();//make conn class object
           
           String str = "insert into room values('"+roomnumber+"', '"+availability+"', '"+cleaning_status+"', '"+price+"', '"+bed_type+"')";
           
           
           conn.s.executeUpdate(str);
           
           JOptionPane.showMessageDialog(null,"New Room Added Successfully");
           setVisible(false);
         }
         catch(Exception e){
           e.printStackTrace();  
         }
      
                }else{
          setVisible(false);
      }
  }
  public static void main(String [] args){
      new AddRooms();
  }
}
