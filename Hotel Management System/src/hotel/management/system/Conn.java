
package hotel.management.system;

import java.sql.*;


public class Conn {
    //create the connection and statement obeject
    Connection c;
    Statement s;
    
    Conn(){
       
      try{
    Class.forName("com.mysql.cj.jdbc.Driver");// it is in jar files
    //for exteranl entity there is achance of exception thats why it is used in try and catch
  c = DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem" ,"root","hellospicy24@");
             s= c.createStatement();
             }
         catch(Exception e){
            e.printStackTrace();
         }
    }
      
   
    }

