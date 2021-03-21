package com.netit.beam_deform_calc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CasesChooser
 */
@WebServlet("/CasesChooser")
public class CasesChooser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CasesChooser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String caseChoose = request.getParameter("case");
		switch (caseChoose) {
		case "case1":
			request.getRequestDispatcher("Pages/case1.html").forward(request, response);
			break;
		case "case2":
			request.getRequestDispatcher("Pages/case2.html").forward(request, response);
			break;
		case "case3":
			request.getRequestDispatcher("Pages/case3.html").forward(request, response);
			break;
		case "case4":
			request.getRequestDispatcher("Pages/case4.html").forward(request, response);
			break;
		case "case5":
			request.getRequestDispatcher("Pages/case5.html").forward(request, response);
			break;
		case "case6":
			request.getRequestDispatcher("Pages/case6.html").forward(request, response);
			break;
		case "case7":
			request.getRequestDispatcher("Pages/case7.html").forward(request, response);
			break;
		case "case8":
			request.getRequestDispatcher("Pages/case8.html").forward(request, response);
			break;
		case "case9":
			request.getRequestDispatcher("Pages/case9.html").forward(request, response);
			break;
		case "case10":
			request.getRequestDispatcher("Pages/case10.html").forward(request, response);
			break;
		case "case11":
			request.getRequestDispatcher("Pages/case11.html").forward(request, response);
			break;
		case "case12":
			request.getRequestDispatcher("Pages/case12.html").forward(request, response);
			break;
		case "case13":
			request.getRequestDispatcher("Pages/case13.html").forward(request, response);
			break;
		case "case14":
			request.getRequestDispatcher("Pages/case14.html").forward(request, response);
			break;
		case "case15":
			request.getRequestDispatcher("Pages/case15.html").forward(request, response);
			break;
		case "case16":
			request.getRequestDispatcher("Pages/case16.html").forward(request, response);
			break;
		case "case17":

			break;
		case "case18":

			break;
		case "case19":

			break;
		case "case20":

			break;
		case "case21":

			break;
		case "case22":

			break;
		case "case23":

			break;
		case "case24":

			break;
		case "case25":

			break;
		case "case26":

			break;
		case "case27":

			break;
		case "case28":

			break;
		case "case29":

			break;
		case "case30":

			break;
		case "case31":

			break;
		case "case32":

			break;
		case "case33":

			break;
		case "case34":

			break;
		case "case35":

			break;
		case "case36":

			break;
		case "case37":

			break;
		case "case38":

			break;
		case "case39":

			break;
		case "case40":

			break;
		case "case41":

			break;
		case "case42":

			break;
		case "case43":

			break;
		default:
			break;
		}
	}

}
