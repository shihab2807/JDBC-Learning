package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class InsertPlayersUsingPS {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		try {
			Driver driver=new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);

			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/player_details","root","Puneeth@8055.");

			String query="insert into cricket values(?,?,?)";
			PreparedStatement ps=conn.prepareStatement(query);

			System.out.println("Enter Jersey No:");
			int j_no=scan.nextInt();
			System.out.println("Enter Name:");
			String name=scan.next();
			System.out.println("Enter Team:");
			String team=scan.next();

			ps.setInt(1, j_no);
			ps.setString(2,name);
			ps.setString(3,team);

			int result=ps.executeUpdate();

			System.out.println(result+" rows inserted.");

			conn.close();

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		scan.close();
	}
}
