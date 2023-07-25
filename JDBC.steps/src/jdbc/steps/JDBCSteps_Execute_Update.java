package jdbc.steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCSteps_Execute_Update {
public static void main(String[] args) {
	Connection conn=null;
	try {
		Driver driver=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		String dburl="jdbc:mysql://localhost:3306/student_details?user=root&password=Puneeth@8055.";
		conn=DriverManager.getConnection(dburl);
		
		Statement st=conn.createStatement();
		String query="update student set name='Amogh' where id=110";
		boolean result=st.execute(query);
		
		if(result==false) {
			System.out.println("Data updated sucessfully.");
		}
		else {
			System.out.println("Data not updated.");
		}
		
	}
	catch(SQLException e){
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
