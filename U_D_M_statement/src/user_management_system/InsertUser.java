package user_management_system;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class InsertUser {
	public static void main(String[] args) {
		try {
			//step 1:Loading and Registering the Driver
			//Loading
			Driver driver=new com.mysql.cj.jdbc.Driver();
			//Register
			DriverManager.registerDriver(driver);

			//step 2:Establishing the connection
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_management_system","root","Puneeth@8055.");

			//step 3:Create Statement and Issue the Result
			Statement st=conn.createStatement();
			int result=st.executeUpdate("insert into user values(102,'Ram','ram@45')");

			//step 4:Processing the Result
			if(result>0) {
				System.out.println("Data inserted successfully.");
			}
			else {
				System.out.println("Data not inserted.");
			}

			//step 5:Close the resources
			conn.close();

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
