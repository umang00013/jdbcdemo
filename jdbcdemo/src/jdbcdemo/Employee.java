package jdbcdemo;

import java.sql.*;
// employee class perform CRUD operations
public class Employee {
	
	Connection con;
    PreparedStatement ps;
    Statement st;
    ResultSet res;
   
    public Connection getConnection()
    {
		return con;
         
    }
    
    public void insertEmployee(String name, String city, String contact)
    {
int count;
		
		try {
			con=assign_connect.createConection();
		String  str="Insert into employee(name,city,contact) values('" + name + "','" + city + "','" + contact + "')";
		st=con.createStatement();
		
count =st.executeUpdate(str);//return no of records
		if(count >0)
		{
			System.out.println("Record Inserted Successfully");
			
		}
		
		//count total no of records in table
		String str1="SELECT COUNT(emp_id) FROM employee";
		res=st.executeQuery(str1);
		int cnt=0;
		while(res.next())
		{
			 cnt=res.getInt(1);
			
		}
		System.out.println("Total no of records is :"+cnt);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
       
    }
    
    public void getEmployee()
    {
    	try {
			con=assign_connect.createConection();
			st=con.createStatement();
			res=st.executeQuery("SELECT * from employee");
					while(res.next())
					{
						System.out.println(res.getString(1)+"\t"+res.getString(2)
						+"\t"+res.getString(3)+"\t"+res.getString(4));
					}
    	}
    	catch (Exception ex)
		{
	System.out.println(ex);
		}
					
				
    }
    public void updateEmployee(int eid,String city)
    {
    	int count;
    	try {
			con=assign_connect.createConection();
		String  str="update employee set city=" + "'" + city + "' where emp_id=" + eid;
		st=con.createStatement();
		
count =st.executeUpdate(str);//return no of records
		if(count >0)
		{
			System.out.println("Record updated Successfully");
			
		}
    	}
    	catch (Exception ex)
		{
	System.out.println(ex);
		}
    	
    }
   
    public void deleteEmployee(int eid)
    {
    	int count;
    	try {
			con=assign_connect.createConection();
		String  str="delete from employee where emp_id=" + eid;
		st=con.createStatement();
		
count =st.executeUpdate(str);//return no of records
		if(count >0)
		{
			System.out.println("Record Deleted Successfully");
			
		}
    	}
    	catch (Exception ex)
		{
	System.out.println(ex);
		}
    
    }

}