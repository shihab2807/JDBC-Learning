package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;


public class BatchExecutionInsert {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		Connection conn=null;
		try {
			Driver driver=new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);

			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/player_details","root","Puneeth@8055.");
			PreparedStatement ps=conn.prepareStatement("insert into cricket values(?,?,?)");
			//int i=1;

			while(true) {
				System.out.println("Enter 1 for inserting.");
				System.out.println("Enter 2 for exit.");
				int n=scan.nextInt();

				if(n==1) {

					System.out.println("Enter Jersey_No:");
					int j_no=scan.nextInt();
					System.out.println("Enter Player Name:");
					String name=scan.next();
					System.out.println("Enter Team Name:");
					String team=scan.next();
					System.out.println("------------------------");
					ps.setString(3, team);
					ps.setInt(1, j_no);
					ps.setString(2, name);
					ps.addBatch();
					//		ps.setString(1, team);
					//		ps.setInt(2, j_no);
					//		ps.addBatch();




					int[] res=ps.executeBatch();
					System.out.println(Arrays.toString(res));
					System.out.println(res.length+" rows get inserted.");}
				if(n==2) {
					break;
				}
			}}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
}
