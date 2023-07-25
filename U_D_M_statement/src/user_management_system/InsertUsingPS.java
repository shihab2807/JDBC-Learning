package user_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class InsertUsingPS {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		try {
			Driver driver=new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);

			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_management_system","root","Puneeth@8055.");

			String query="insert into user values(?,?,?)";
			PreparedStatement ps=conn.prepareStatement(query);

			System.out.println("Enter Id:");
			int id=scan.nextInt();
			System.out.println("Enter Name:");
			String name=scan.next();
			System.out.println("Enter Email-Id:");
			String email=scan.next();

			ps.setInt(1, id);
			ps.setString(2,name);
			ps.setString(3,email);

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
