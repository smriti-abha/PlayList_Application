
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class AddDriver extends JFrame implements ActionListener{
    JButton add , cancel;
    JTextField tfname,tfcomapny,tfage,tfmodel,tflocation;
    JComboBox availablecombo, gendercombo;
    JLabel  lblroomno,lblage,lblclean,lblprice,lbltype,lblavailable,lbllocation;
  AddDriver(){
      setLayout(null);
      setVisible(true);
     
      JLabel heading = new JLabel("Add Drivers");
      heading.setFont(new Font("Tahoma", Font.PLAIN, 18));
      heading.setBounds(150,10,200,20);
      add(heading);
      
        lblroomno = new JLabel("Name");
      lblroomno.setFont(new Font("Tahoma", Font.BOLD, 16));
      lblroomno.setBounds(60,70,120,30);
      add(lblroomno);
      
       tfname= new JTextField();
      tfname.setBounds(200,70,150,30);
      add(tfname);
      
         lblage = new JLabel("Age");
      lblage.setFont(new Font("Tahoma", Font.BOLD, 16));
      lblage.setBounds(60,110,120,30);
      add(lblage);
      
       tfage= new JTextField();
      tfage.setBounds(200,110,150,30);
      add(tfage);
      
      
        lblclean = new JLabel("Gender");
      lblclean.setFont(new Font("Tahoma", Font.BOLD, 16));
      lblclean.setBounds(60,150,120,30);
      add(lblclean);
      
      String cleanoptions []={"Male","Female"};
      gendercombo =new JComboBox(cleanoptions);
     gendercombo.setBounds(200,150,150,30);
      gendercombo.setForeground(Color.WHITE);
      add(gendercombo);
      
        lblprice = new JLabel("Car Company");
      lblprice.setFont(new Font("Tahoma", Font.BOLD, 16));
      lblprice.setBounds(60,190,120,30);
      add(lblprice);
      
       tfcomapny= new JTextField();
      tfcomapny.setBounds(200,190,150,30);
      add(tfcomapny);
      
        lbltype = new JLabel(" Car Model");
     lbltype.setFont(new Font("Tahoma", Font.BOLD, 16));
     lbltype.setBounds(60,230,120,30);
      add(lbltype);
      
     tfmodel= new JTextField();
     tfmodel.setBounds(200,230,150,30);
      add(tfmodel);
      
       lblavailable = new JLabel("Available");
     lblavailable.setFont(new Font("Tahoma", Font.BOLD, 16));
     lblavailable.setBounds(60,270,120,30);
      add(lblavailable);
      
       String diveroptions []={"Available","Busy"};
       availablecombo =new JComboBox(diveroptions);
     availablecombo.setBounds(200,270,150,30);
      availablecombo.setForeground(Color.WHITE);
      add(availablecombo);
      
       lbllocation = new JLabel("Location");
     lbllocation.setFont(new Font("Tahoma", Font.BOLD, 16));
     lbllocation.setBounds(60,310,120,30);
      add(lbllocation);
      
       tflocation= new JTextField();
     tflocation.setBounds(200,310,150,30);
      add(tflocation);
      
       add = new JButton("Add Driver");
      add.setForeground(Color.WHITE);
       add.setBackground(Color.BLACK);
       add.setBounds(60,370,130,30);
       add.addActionListener(this);
       add(add);
      
       cancel = new JButton("Cancel Driver");
     cancel.setForeground(Color.WHITE);
      cancel.setBackground(Color.BLACK);
      cancel.setBounds(220,370,130,30);
       cancel.addActionListener(this);
       add(cancel);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("eleven.jpg"));
       Image i2=i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(400,30,500,300);
       add(image);
       
      
       setBounds(300,200,980,470);
      getContentPane().setBackground(Color.WHITE);
      
  } 
  public void actionPerformed(ActionEvent ae){
      if(ae.getSource()==add){
        String name =tfname.getText();
        String age = tfage.getText();
        String gender = (String) gendercombo.getSelectedItem();
         String company = tfcomapny.getText();
         String model = tfmodel.getText();
         String availability =(String) availablecombo.getSelectedItem();
                 String location=tflocation.getText();
                 
         try{
           Conn conn = new Conn();
           
           String str = "insert into driver values('"+name+"', '"+age+"', '"+gender+"', '"+company+"', '"+model+"', '"+availability+"', '"+location+"')";
           
           
           
           conn.s.executeUpdate(str);
           
           JOptionPane.showMessageDialog(null,"New Driver Added Successfully");
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
      new AddDriver();
  }
}

