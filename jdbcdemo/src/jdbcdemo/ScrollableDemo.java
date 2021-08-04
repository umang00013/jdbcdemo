package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScrollableDemo {

	public static void main(String[] args) {
		Connection con;
		Statement stmt;
		ResultSet rs;
		
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			
	con =DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","admin");
			
	//Create Scrollable ResultSet
	stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	
	rs=stmt.executeQuery("select * from skills");
	
	while(rs.next())
    {
System.out.println(rs.getInt(1)+"  "+rs.getString(2));
    }
	
	System.out.println("**Display Records from bottom to top****");
	rs.afterLast();
	
	while(rs.previous())
    {
System.out.println(rs.getInt(1)+"  "+rs.getString(2));
    }
	
	System.out.println("***Display 3rd Record****");
	rs.absolute(3);//move the cursor to third record
	System.out.println(rs.getInt(1)+"  "+rs.getString(2));
	System.out.println("**********");

	System.out.println("***Display 2nd Record****");
	rs.relative(-1);//move the cursor to 2nd record through relative
	System.out.println(rs.getInt(1)+"  "+rs.getString(2));
	System.out.println("**********");
	
	System.out.println("***Display first record using first() ****");
	rs.first();//move the cursor to 2nd record through relative
	System.out.println(rs.getInt(1)+"  "+rs.getString(2));
	System.out.println("**********");
	
	rs.absolute(4);
	System.out.println("Current Cursor Position :"+rs.getRow());
	//System.out.println("Total no of records "+);
	rs.last();
	System.out.println("Total no of records "+rs.getRow());
	con.close();
		}
catch(Exception e){ 
            
            System.out.println(e);
            }  
	}

}