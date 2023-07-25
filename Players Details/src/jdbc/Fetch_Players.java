package jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Fetch_Players {
	public static void main(String[] args) {

		try {
			Driver driver=new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);

			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/player_details","root","Puneeth@8055.");

			Statement st=conn.createStatement();
			
			boolean result=st.execute("select * from cricket");
			ResultSet set=st.getResultSet();
			System.out.println(result);
			System.out.println("-------------------------------");
			System.out.println("J_No \tName\t        Team");
			System.out.println("-------------------------------");
			
			
			while(set.next()) {
				System.out.println(set.getInt(1)+"   \t"+set.getString(2)+"   \t"+set.getString(3));
				
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
