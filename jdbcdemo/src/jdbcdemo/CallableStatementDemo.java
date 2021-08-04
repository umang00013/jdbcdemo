package jdbcdemo;
import java.sql.*;
import java.util.Scanner;

class Skills
{
	Connection con;
    CallableStatement cstmt;
    ResultSet rs;
    String query;
    Scanner scan;
    
    public Skills() throws Exception
    {
    	con=ConnectionUtil.createConection();
    	scan = new Scanner(System.in);
    }
    
    public void getSkills(int candidateID) throws SQLException
    {
    	cstmt=con.prepareCall("{CALL get_candidate_skill(?) }");
    	cstmt.setInt(1, candidateID);
    	rs=cstmt.executeQuery();
    	
    	while (rs.next()) {
            System.out.println(String.format("%s - %s",
                    rs.getString("first_name") + " "
                    + rs.getString("last_name"),
                    rs.getString("skill")));
    }
	
	//getmycandidateskills
}
}
public class CallableStatementDemo {
	
	public static void main(String[] args) {
		
		try {
			Skills s=new Skills();
			Scanner scan= new Scanner(System.in);
			
			System.out.println("Enter Candidate Id : ");
			int id=scan.nextInt();
			
			s.getSkills(id);
			scan.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		

	}

}


