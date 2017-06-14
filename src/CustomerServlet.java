
import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import resumeDBWithServlet.model.ConnectionManager;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ConnectionManager cm = new ConnectionManager();
	Statement stm;
	ResultSet rs;
	
	
    public CustomerServlet() {
        super();
        
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nextURL = "/view.jsp";
		String lastName = request.getParameter("last_name");
		Connection con = cm.getConnection();
		
		String query = "SELECT FullName, Title, FirstName, LastName, StreetAddress, City, State,ZipCode, EmailAddress, Position, Company  FROM customer WHERE LastName = '"+ lastName + "'";
		try{
			
			stm = con.createStatement();
			rs = stm.executeQuery(query);
		
			while(rs.next()){
				
				String CustomerDetail = rs.getString(1) + "\n<br>" 
				                        +rs.getString(2) + " " +rs.getString(5) + " "+ rs.getString(6) + " "+ rs.getString(7) + " \n<br>"
				                        + rs.getString(8) + " \n<br>"
				                        + rs.getString(9) + " \n<br>"
				                        + rs.getString(10) + "\n<br>"
				                        + rs.getString(10);
				CustomerDetail = CustomerDetail.concat(CustomerDetail);
				//SCustomerDetail = CustomerDetail.concat(CustomerDetail);
				request.setAttribute("msg", CustomerDetail);
			}
			
			getServletContext().getRequestDispatcher(nextURL).forward(request,response);
			
					
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
