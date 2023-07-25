package jdbc.steps;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class JDBCSteps_Execute_Insert {
	public static void main(String[] args) {
		
		Connection conn=null;
		
		try {
			Driver driver=new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);

			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_details?user=root&password=Puneeth@8055.");

			Statement st=conn.createStatement();
			boolean result=st.execute("insert into student values(110,'Ramesh',33)");

			if(result==false) {
				System.out.println("Data inserted sucessfully."); 
			}else {
				System.out.println("Data not inserted.");
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
