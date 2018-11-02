

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			String sid=request.getParameter("id");
			String sage=request.getParameter("age");
			String sname=request.getParameter("name");
			String passw=request.getParameter("pass");
			Class.forName("org.h2.Driver");
			Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","admin","1234");
			Statement statement=conn.createStatement();
			String sql = "INSERT INTO student " + "VALUES('"+sid+"','"+sname+"','"+sage+"','"+passw+"')";
			statement.executeUpdate(sql);
	        PrintWriter p=response.getWriter();
			p.println("entry added");
			p.println(sql);
			statement.close();
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised"+e);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
