package myserlvets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8766233910301257216L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		//out.write(registerServlet.Logins.get(0).toString());
		
		String name=req.getParameter("username");
		String pass=req.getParameter("password");
		
		
			
			
			Connection con=null;
			Statement stmt=null;
			ResultSet rs;
			
			//resp.sendRedirect("https://www.google.com");
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//step 2
				 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl1","system","moose777");
				 stmt=con.createStatement();
				  rs=stmt.executeQuery("select * from UserDetail where username='"+name+"' and password='"+pass+"'");
				  while (rs.next())
					{
					  RequestDispatcher rd=req.getRequestDispatcher("wel");
						rd.forward(req, resp);
					}
					
					
			} catch (ClassNotFoundException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//this is where the sql table didnt find it 
				out.print("UserName Was Not Found");
				RequestDispatcher rd=req.getRequestDispatcher("Log");
				rd.include(req, resp);
				
			}
			
	}
	
}
			
			
			
			
			/*for(int j=0; j<registerServlet.Logins.size(); j++){	
			
			
			if(registerServlet.Logins.get(j).getUser_name().equals(name)) {
				if(registerServlet.Logins.get(j).getPass().equals(pass)) {
					//do the login
					RequestDispatcher rd=req.getRequestDispatcher("Wel");
					rd.forward(req, resp);
			
				}else {
					out.print("Invalid password");
					RequestDispatcher rd=req.getRequestDispatcher("login.html");
					rd.include(req, resp);
				}
				
			}else {continue;}
			
		}
		out.print("UserName Was Not Found");
		RequestDispatcher rd=req.getRequestDispatcher("Log");
		rd.include(req, resp);
			
	}

}



		registerServlet.Logins.stream().forEach(u->{
if(u.getUser_name() == name) {
if(u.getPass()==pass) {
	//do the login
	
	
}
}
});**/