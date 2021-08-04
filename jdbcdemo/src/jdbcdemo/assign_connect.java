package jdbcdemo;
import java.sql.Connection;
import java.sql.DriverManager;
public class assign_connect{
	public static Connection createConection() throws Exception
	{
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
	Connection	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/assign1","root","admin");
		return con;
	}

}





