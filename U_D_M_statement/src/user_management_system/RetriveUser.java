package user_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class RetriveUser {
	public static void main(String[] args) {

		try {
			Driver driver=new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);

			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_management_system","root","Puneeth@8055.");

			Statement st=conn.createStatement();
			ResultSet res=st.executeQuery("select * from user");
			
			System.out.println("ID\tName\tEmail ID");
			System.out.println("---------------------------");

			while(res.next()) {
				System.out.println(res.getInt(1)+"\t"+res.getString(2)+"\t"+res.getString(3));

			}
			conn.close();

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
