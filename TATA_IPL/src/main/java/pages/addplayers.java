   package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.player_dao;

import static dao.player_dao.getAllAbbrevation;

/**
 * Servlet implementation class addplayers
 */
@WebServlet("/addplayer")
public class addplayers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
	
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		player_dao pdao;
		
		System.out.println("after dopost");
		try (PrintWriter pw = response.getWriter()) {
			pdao = new player_dao();
			List<String> teamsAbbreviations = pdao.getAllAbbrevation();
			pw.print("<form method='post' action='add_player'>");
			pw.print("<table border='1' style='background-color: pink; margin: auto'>");
			pw.print("<tr><td colspan='2'><img src='ipl_show_page-1680082941527.avif' width='500' height='250'></td></tr><tr><td>");
			pw.print("<h5> Choose a Team :</td><td> <select name='abbrevation'>");
			for (String s : teamsAbbreviations)
				pw.print("<h5><option value='" + s +   "'</option>" + s + "</h5>");
			pw.print("</h5> </select></td></tr>");
			pw.print("<tr><td><h5>Player fname</td> <td><input type='text' name='fm'/></h5></td></tr>");
			pw.print("<tr><td><h5>Player lname</td><td> <input type='text' name='lm'/></h5></td></tr>");
			pw.print("<tr><td><h5>DoB </td><td> <input type='date' name='dob'/></h5></td></tr>");
			pw.print("<tr><td><h5>Batting Avg </td><td> <input type='number' name='avg'/></h5></td></tr>");
			pw.print("<tr><td><h5>Wickets Taken </td><td> <input type='text' name='wickets'/></h5></td></tr>");
			pw.print("<tr><td  colspan='2'><h5><input type='submit' value='Add New Player'/></h5></td></tr>");
			pw.print("/<table>");
			pw.print("</form>");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
