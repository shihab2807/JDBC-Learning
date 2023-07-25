package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class BatchExecutionDelete {
	//	static Connection conn;
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		Connection conn=null;

		try {
			Driver driver=new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);

			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/player_details","root","Puneeth@8055.");
			PreparedStatement ps=conn.prepareStatement("delete from cricket where jersey_no=?");


			while(true) {
				System.out.println("Enter 1 to delete.");
				System.out.println("Enter 2 to exit.");
				int n=scan.nextInt();

				if(n==1) {
					System.out.println("Enter Jersey_No:");
					int j_no=scan.nextInt();
					//				System.out.println("Enter Team Name:");
					//				String team=scan.next();
					//				ps.setString(1, team);
					ps.setInt(1, j_no);
					ps.addBatch();
					//		ps.setString(1, team);
					//		ps.setInt(2, j_no);
					//		ps.addBatch();
					int[] res=ps.executeBatch();
					System.out.println(Arrays.toString(res));
					System.out.println(res.length+" rows get deleted.");
				}
				if(n==2) {
					break;
				}
			}
		}

		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}