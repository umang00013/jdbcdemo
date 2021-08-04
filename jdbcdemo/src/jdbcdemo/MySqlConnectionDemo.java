package jdbcdemo;
import java.sql.*;
public class MySqlConnectionDemo {

	public static void main(String[] args) {
		Connection con;
		Statement stmt;
		ResultSet rs;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//create a connection
			//craete a session b/w java and mysql
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","admin");
			//create statement object
			stmt=con.createStatement();
			//execute a query
			rs=stmt.executeQuery("Select * from employees");
			//traverse result set
			while(rs.next())
			{
	System.out.println(rs.getInt(1)+" "+rs.getString(3)+" "+rs.getString("email")+" "+rs.getString(8));
			}
			con.close();
			/*System.out.println("Display specific record from a db");
			rs.absolute(3); // move cursor to 3 row in rs
			
			System.out.println(rs.getInt(1)+" "+rs.getString(3)+" "+rs.getString("email")+
			" "+rs.getString(8));*/
			
			
			
		}  catch ( Exception e) {
			
			e.printStackTrace();
		}

	}

}
