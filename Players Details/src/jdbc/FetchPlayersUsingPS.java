package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class FetchPlayersUsingPS {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		try {
			Driver driver=new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);

			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/player_details","root","Puneeth@8055.");


			String query="select * from cricket where jersey_no=?";
			PreparedStatement ps=conn.prepareStatement(query);

			System.out.println("Enter Jersey No:");
			int j_no=scan.nextInt();
			//			System.out.println("Enter Name:");
			//			String name=scan.next();
			//			System.out.println("Enter Team:");
			//			String team=scan.next();
			//
			ps.setInt(1, j_no);
			//			ps.setString(2,name);
			//			ps.setString(3,team);

			ResultSet res=ps.executeQuery();

			System.out.println("J_no\tName\tTeam");
			System.out.println("----------------------------");

			while(res.next()) {
				System.out.println(res.getInt(1)+"\t"+res.getString(2)+"\t"+res.getString(3));
			}

			conn.close();

		}

		catch(SQLException e) {
			e.printStackTrace();
		}
		scan.close();
	}
}
