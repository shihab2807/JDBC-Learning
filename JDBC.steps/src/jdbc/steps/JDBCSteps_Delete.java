package jdbc.steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCSteps_Delete {
	public static void main(String[] args) {
		try {
			//Step 1:Load and Register the Driver
			Driver driver=new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			
			//Step 2:Establish a Connection
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_details?user=root&password=Puneeth@8055.");
			
			//Step 3:Create Statement and Issue the Result
			Statement st=conn.createStatement();
			int result=st.executeUpdate("delete from student where id=102");
			
			//Step 4:Processing the Result
			if(result>0) {
				System.out.println(result+" Data Deleted Scucessfully.");
			}
			else {
				System.out.println("Data Not Deleted.");
			}
			//Step 5:Close the Resources
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
