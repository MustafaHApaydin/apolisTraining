package myserlvets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class registerServlet extends HttpServlet{
	static LinkedList<Users> Logins = new LinkedList<>();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		String nameIn = req.getParameter("username");
		String passIn = req.getParameter("password");
		String emailIn = req.getParameter("email");
		String adrr = req.getParameter("address");
		String phone = req.getParameter("phone");
		
		//create new User for Verification purposes
		if(nameIn!=null&&passIn!=null&&emailIn!=null&&phone!=null&&adrr!=null)
					{
				//Users newUser = new Users(nameIn, passIn, emailIn, phone, adrr);
				//Logins.add(newUser);
					//System.out.println("New User has been created");
				//	System.out.println(newUser);
					
					
					
			
					
					Connection con=null;
					PreparedStatement stmt;
		
					
					//resp.sendRedirect("https://www.google.com");
					try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
						//step 2
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Moose777");
					System.out.println("ConnectionSuccessful");
					
					 
					//need condition check to see if table exists 
					//String createTable = "create table users_details(username varchar2(25) , pass varchar2(25), email varchar2(25), phone varchar2(10), address varchar2(50))";
					//stmt.executeUpdate(createTable);
					//System.out.println("System has created Table");
					
					
					
					stmt = con.prepareStatement("insert into user_details Values(?,?,?,?,?)");
					stmt.setString(1, nameIn);
					stmt.setString(2, passIn);
					stmt.setString(3, emailIn);
					stmt.setString(4, adrr);
					stmt.setString(5, phone);
					
					
					 
					RequestDispatcher rd=req.getRequestDispatcher("log");
					rd.forward(req, resp);
								
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						 System.out.println("----------------------------------Connection Error------------------------------------1");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						 System.out.println("----------------------------------Connection Error------------------------------------2");
						//this is where the sql table didnt find it 
						out.print("There was an error Please Try Again");
						
					}
					}
		else {
			out.print("There was an error Please Try Again");
			RequestDispatcher rd=req.getRequestDispatcher("reg");
			rd.include(req, resp);
		}
	

	}
	
}
