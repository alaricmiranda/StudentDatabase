import java.sql.*;
//DELETE FROM student WHERE stdid = 100 delete row with id 101
// String sql = "INSERT INTO Registration " + "VALUES (100, 'Zara', 'Ali', 18)" insert new 
//update student set stdage=101 where stdid=100 update specific in row with 1d 101
//ALTER TABLE student DROP COLUMN stdphone remove collum
//ALTER TABLE student ADD stdphone varchar(10)add collum
//after making any of these statement.executeUPdate(string name)
public class Dbhandler
{
	public static void main(String arg[])
	{

		try
		{
			Class.forName("org.h2.Driver");
			Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","admin","1234");
			Statement statement=conn.createStatement();
			
			ResultSet rs=statement.executeQuery("select * from Student");
			
	        
			while(rs.next())
			{
				System.out.print(rs.getInt("stdid")+":::");
				System.out.print(rs.getString("stdname")+":::");
				System.out.print(rs.getInt("stdphone")+":::");
				System.out.println(rs.getInt("stdage")+":::");
			}
			
			statement.close();
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised"+e);
		}
		
	}
}