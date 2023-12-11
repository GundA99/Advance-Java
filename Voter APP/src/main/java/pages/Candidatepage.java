package pages;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Candidate_Dao;
import pojos.Candidate;
import pojos.User;

/**
 * Servlet implementation class Candidatepage
 */
@WebServlet("/Candidate")
public class Candidatepage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter())
		{
			pw.print("<h4>In candidate list page</h4>");

			HttpSession hs = request.getSession();
			
			System.out.println("Session is now "+hs.isNew());
			System.out.println("Session id "+hs.getId());
			User user;
			user = (User) hs.getAttribute("user_info");
			
			
			if(user!=null)
			{
				Candidate_Dao candidatesdao = (Candidate_Dao) hs.getAttribute("candi_dao");
				List<Candidate> clist =candidatesdao.getAllCandidates();
			pw.print("<h3> Hello "+user.getFirstName()+" "+user.getLastName()+"</h3>");
			pw.print("<form action='logout' method='post'>");
			for(Candidate c: clist)
			{
				pw.print("<h3><input type='radio' name='candidate_id' value='"+c.getId()+"'> "
			+ c.getParty()+"</input></h3>");
			}
			pw.print("<h4><input type='submit' value='Cast a vote'/><h4>");
			pw.print("</form>");
			
			}
			else
			{
				pw.print("<h5> No Cookies, Session Traking failed !!!</h5>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
