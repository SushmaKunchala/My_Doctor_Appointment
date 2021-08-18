package doctor_appointment;

import java.sql.*;

public class Connection_class {

    Connection con;
	public Connection ConnectDB(){
        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL","hr","sushmakunchala585");
			System.out.println("Connection is successful");
		    return con;
        }
        catch (Exception e) {
            System.out.println(e);
           return null;
        }

    }
   
        

  }

