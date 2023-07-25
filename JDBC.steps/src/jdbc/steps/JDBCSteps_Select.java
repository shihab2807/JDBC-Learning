package jdbc.steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class JDBCSteps_Select {
	public static void main(String[] args) {
		try {
			Driver driver=new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);

			String dburl="jdbc:mysql://localhost:3306/student_details?user=root&password=Puneeth@8055.";
			Connection conn=DriverManager.getConnection(dburl);

			Statement st=conn.createStatement();
			ResultSet res=st.executeQuery("select * from student");
			System.out.println("ID"+"\tName"+"\tAge");
			System.out.println("---------------------");

			while(res.next()) {
//				System.out.print(res.getInt("id")+"\t");
//				System.out.print(res.getString(2)+"\t");
//				System.out.print(res.getInt(3)+"\t");
//				System.out.println();
				System.out.println(res.getInt(1)+"\t"+res.getString(2)+"\t"+res.getInt(3));
				System.out.println(".....................");
			}

			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
