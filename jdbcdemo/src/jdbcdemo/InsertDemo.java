package jdbcdemo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertDemo {

	public static void main(String[] args) {
		Connection con;
		Statement stmt;
		ResultSet rs;
		int count;
		
		try {
			con=ConnectionUtil.createConection();
		String  str="Insert into skills(name) VALUES('Node')";
		stmt=con.createStatement();
		
count =stmt.executeUpdate(str);//return no of records
		if(count >0)
		{
			System.out.println("Record Inserted Successfully");
			
		}
		
		//count total no of records in table
		String str1="SELECT COUNT(id) FROM skills";
		rs=stmt.executeQuery(str1);
		int cnt=0;
		while(rs.next())
		{
			 cnt=rs.getInt(1);
			
		}
		System.out.println("Total no of records is :"+cnt);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}