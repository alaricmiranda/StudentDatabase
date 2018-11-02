

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			Class.forName("org.h2.Driver");
			Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","admin","1234");
			Statement statement=conn.createStatement();
			String sid=request.getParameter("idl");
			String pass=request.getParameter("passl");
			ResultSet rs=statement.executeQuery("select * from Student");
			boolean sucess=false;
	        PrintWriter p=response.getWriter();
			while(rs.next())
			{
				String i=rs.getString("stdid");
				if(i.equals(sid))
				{
					String pw=rs.getString("stdpass");
					if(pw.equals(pass))
					{
						sucess=true;
						break;
					}
				}
			}
			if(sucess)
			{
				p.println("welcome:"+rs.getString("stdname"));
				p.println("redirecting to Userpage");
				//RequestDispatcher dispatcher=request.getRequestDispatcher("login.html");
				//dispatcher.include(request, response);
			}
			else
			{
				p.println("Wrong id or password");
				RequestDispatcher dispatcher=request.getRequestDispatcher("index.html");
				dispatcher.include(request, response);
			}
			
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
