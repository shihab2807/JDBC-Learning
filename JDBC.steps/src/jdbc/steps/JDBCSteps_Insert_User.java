package jdbc.steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCSteps_Insert_User {
public static void main(String[] args) {
	try {
	Driver driver=new com.mysql.cj.jdbc.Driver();
	DriverManager.registerDriver(driver);
	
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_details?user=root&password=Puneeth@8055.");
	Statement st=conn.createStatement();
	int res=st.executeUpdate("insert into user_details.user values (112,'Karna',40)");
	if(res>0) {
		System.out.println("Data inserted sucessfully.");
	}
	else {
		System.out.println("Data not inserted.");
	}
	
	conn.close();
	
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
}
}
