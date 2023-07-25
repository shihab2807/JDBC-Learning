package jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete_Players {
	public static void main(String[] args) {

		try {
			Driver driver=new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);

			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/player_details","root","Puneeth@8055.");

			Statement st=conn.createStatement();
			boolean result=st.execute("delete from cricket where jersey_no=45");

			if(result==false) {
				System.out.println("Data deleted sucessfully."); 
			}else {
				System.out.println("Data not deleted.");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
