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

			break;
		case "case2":

			break;
		case "case3":

			break;
		case "case4":

			break;
		case "case5":

			break;
		case "case6":

			break;
		case "case7":

			break;
		case "case8":

			break;
		case "case9":

			break;
		case "case10":

			break;
		case "case11":

			break;
		case "case12":

			break;
		case "case13":

			break;
		case "case14":

			break;
		case "case15":

			break;
		case "case16":

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
