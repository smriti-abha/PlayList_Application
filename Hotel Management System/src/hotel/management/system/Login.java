
package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;



public class Login extends JFrame implements ActionListener{
    JTextField username;
  //  JLabel user,pass;
    JPasswordField password;
    JButton login , cancel;
    
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //for user id
         JLabel  user= new JLabel("Username");
        user.setBounds(40,20,100,70);
        add(user);
        
          //for textfield username
          username= new JTextField();
           username.setBounds(150,20,150,30);
           add(username);
           
        // for password
          JLabel  pass= new JLabel("Password");
          pass.setBounds(40,70,100,70);
        add(pass);
        
       //for textfield password
          password= new JPasswordField ();
           password.setBounds(150,70,150,30);
        add(password);
        
        //for login button
        login= new JButton("Login");
        login.setBounds(40,150,120,30);
        login.setBackground(Color.BLACK);
         login.setForeground(Color.WHITE);
         login.addActionListener(this);
        add(login);
        
        //for cancel button
         cancel= new JButton("Cancel");
        cancel.setBounds(180,150,120,30);
        cancel.setBackground(Color.BLACK);
         cancel.setForeground(Color.WHITE);
          cancel.addActionListener(this);
        add(cancel);
        
         // for image
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image);
        
      setBounds(500,200,600,300);
      setVisible(true);
    }
//    
//   
//    
//   
    public void actionPerformed(ActionEvent ae){
     if(ae.getSource()==login){
       String user = username.getText();
       String pass = password.getText();
       
       
       try{
             Conn c = new Conn();
             
    String query = "select * from login where username = '" + user + "' and password= '" + pass +"'";
     ResultSet rs = c.s.executeQuery(query); // resturn resultset
     
     if(rs.next()){
         setVisible(false);
        new Dashboard();
         }
     else{
         JOptionPane.showMessageDialog(null,"Invalid Username Or Password");
         setVisible(false);
     }
     
             }
         catch(Exception e){
             e.printStackTrace();
         }
       
     }
     else if(ae.getSource()==cancel){
         setVisible(false);
     }
    }
    public static void main (String[] args){
        new  Login();
        
    }
}

