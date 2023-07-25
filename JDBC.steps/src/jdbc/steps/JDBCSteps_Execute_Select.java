package jdbc.steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCSteps_Execute_Select {
	public static void main(String[] args) {
		Connection conn=null;

		try {
			Driver driver=new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);

			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_details?user=root&password=Puneeth@8055.");

			Statement st=conn.createStatement();
			boolean result=st.execute("select * from user");
			ResultSet res=st.getResultSet();
			System.out.println("ID"+"\tName"+"\tAge");
			System.out.println("----------------------");
			System.out.println(result);
			while(res.next())
			{
				System.out.println(res.getInt(1)+"\t"+res.getString(2)+"\t"+res.getInt(3));
			}

		}
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
