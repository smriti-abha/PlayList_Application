
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Dashboard extends JFrame implements ActionListener{
    Dashboard(){
        setBounds(0,0, 550,1000);
        setLayout(null); //default layout is border 
        //and if not set null then i am unable to set image according to me
        //for adding image
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("third.jpg"));
        
        //for scaling
        Image i2= i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);
       
        // label for writing text
        JLabel text= new JLabel("HOTEL METROPOLE WELCOMES YOU!");
        text.setBounds(400,80,1000,50);
        text.setFont(new Font("Tahoma",Font.ITALIC,46));
        image.add(text);
         text.setForeground(Color.WHITE);
         
         //for making menu
         JMenuBar mb = new JMenuBar();
         mb.setBounds(0, 0, 1550, 30);
         image.add(mb);
         //menu 1
          JMenu hotel = new JMenu("HOTEL MANAGEMENT");
          hotel.setForeground(Color.RED);
         mb.add(hotel);
         
         JMenuItem reception = new JMenuItem("RECEPTION");
         reception.addActionListener(this);
         hotel.add(reception);
         //menu 2
         JMenu admin = new JMenu("ADMIN");
         admin.setForeground(Color.BLUE);
         mb.add(admin);
         //here use the JDBC
        setVisible(true);
        
         JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
          addemployee.addActionListener(this);
         admin.add(addemployee);
         
          JMenuItem addrooms = new JMenuItem("ADD ROOMS");
           addrooms.addActionListener(this);
         admin.add(addrooms);
         
          JMenuItem adddriver = new JMenuItem("ADD DRIVERS");
          adddriver.addActionListener(this);
         admin.add(adddriver);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("ADD EMPLOYEE")){
        new AddEmployee();
        }
        else if(ae.getActionCommand().equals("ADD ROOMS"))
        {
      new AddRooms();
        }
        else if(ae.getActionCommand().equals("ADD DRIVERS")){
            new AddDriver();
        }
        else if(ae.getActionCommand().equals("RECEPTION")){
            new Reception();
        }
    }
    public static void main(String []args){
        new Dashboard().setVisible(true);
    }
}
