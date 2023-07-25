package jdbc.steps;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Driver;

public class JDBCSteps_Insert {
	public static void main(String[] args) {
		try {
			//Step 1:Load and Register the Driver
			Driver driver=new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);

			//Step 2: Establish a Connection
			String dburl="jdbc:mysql://localhost:3306";
			Connection conn=DriverManager.getConnection(dburl,"root","Puneeth@8055.");

			//Step 3:Create Statement and Issue the Result
			Statement st=conn.createStatement();
			String query="Insert into student_details.student values(108,'King',30)";
			int result=st.executeUpdate(query);

			//Step 4:Processing The Result
			if(result>0) {
				System.out.println(result+" Data Sucessfully Inserted!!");
			}
			else {
				System.out.println("data not inserted");
			}
			//Step 5:Close the resources
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

	}
}
