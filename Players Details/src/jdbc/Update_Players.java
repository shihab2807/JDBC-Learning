package jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update_Players {
	public static void main(String[] args) {

		try {
			Driver driver=new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);

			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/player_details","root","Puneeth@8055.");

			Statement st=conn.createStatement();
			boolean result=st.execute("update cricket set player_name='Rishab' where jersey_no=22");

			if(result==false) {
				System.out.println("Data updated sucessfully."); 
			}else {
				System.out.println("Data not updated.");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
