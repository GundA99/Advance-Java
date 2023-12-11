package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.player_dao;

import static dao.player_dao.*;

import static dao.player_dao.*;
import pojos.player;

/**
 * Servlet implementation class addmition
 */
@WebServlet("/add_player")
public class addmition extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		String fn = request.getParameter("fm");
		String ln = request.getParameter("lm");
		Date dob = Date.valueOf(request.getParameter("dob"));
		double batingAvg = Double.parseDouble(request.getParameter("avg"));
		int wicket = Integer.parseInt(request.getParameter("wickets"));
		String team = request.getParameter("abbrevation");
		player_dao dao;
		int age = LocalDate.now().getYear()- dob.toLocalDate().getYear();

		try {
			dao = new player_dao();
			int id = dao.getIdByAbbrevation(team);
			try (PrintWriter pw = response.getWriter()) {
				if (age < 20) {
					pw.print("Age is not less then 20");
				} else {
					player p1 = new player(fn, ln, wicket, id, batingAvg, dob);

					pw.print(dao.addplayer(p1));
				}
			}
			System.out.println("in addmitions");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

}
