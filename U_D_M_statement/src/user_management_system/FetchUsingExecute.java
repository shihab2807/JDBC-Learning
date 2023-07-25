package user_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchUsingExecute {
	
	public static void main(String[] args) {
		try {
			//loading and registering the driver
			Driver driver=new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			
			//establishing the connection
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_management_system","root","Puneeth@8055.");
			
			//creating the statement
			Statement st=conn.createStatement();
			
			//executing the query
			boolean result=st.execute("select * from user");
			ResultSet set=st.getResultSet();
			System.out.println(result);
			System.out.println("----------------------------");
			
			
			while(set.next()) {
				System.out.print(set.getInt(1)+"\t"+set.getString(2)+"\t"+set.getString(3));
				
			}
			
			
			//closing the connection
			conn.close();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
