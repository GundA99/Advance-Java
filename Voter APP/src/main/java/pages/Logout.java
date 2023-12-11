package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.tribes.group.Response;

import pojos.User;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			HttpSession session = request.getSession();

			User user = (User) session.getAttribute("user_info");
			if (user != null) {
				pw.print("<h3> hello, " + user.getFirstName() + "</h3><br>");
				pw.print(
						"<h2 style='background-color:cyan; color:red'> You have already voted , Can't vote again !!!!!");

			} else {
				pw.print("\"<h5> No Cookies , Session Tracking failed!!!!!</h5>");
				session.invalidate();
			}
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter())
		{
			pw.print("<h5> In logout  page </h5>");
			HttpSession session = request.getSession();
			
			User user = (User) session.getAttribute("user_info");
			if(user!=null) {
			Candidate_Dao dao = (Candidate_Dao) session.getAttribute("candi_dao");
			UserDaoImpl userdao = (UserDaoImpl) session.getAttribute("user_dao");
			pw.print("<h4> Hello, "+user.getFirstName()+" "+user.getLastName()+"</h4></br>");
			int custid = Integer.parseInt(request.getParameter("candidate_id"));
			
			pw.print("<h4>"+userdao.updateVotingStatus(user.getUserId())+"</h4>");
			pw.print("<h4>"+dao.updateVote(custid)+"</h4>");
			
			}
			else
			{
				pw.print("<h5> No Cookies , Session Tracking failed!!!!!</h5>");
			}
			
			
			
		} catch (SQLException e) {

			throw new ServletException("err in do-post of " + getClass(), e);
		}
		
	}

}









