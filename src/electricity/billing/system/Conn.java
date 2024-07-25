package electricity.billing.system;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    
    Conn(){
        
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs","root","neha");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
