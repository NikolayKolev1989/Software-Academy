package servlets;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import calc.classes.Case1;
import main.Calculations;

/**
 * Servlet implementation class casesServlet
 */
@WebServlet("/casesServlet")


public class casesServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
//	private Calculations calculations;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public casesServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute(getServletInfo()).equals("case1")) {
			
			String selectMenu = request.getParameter("profile");
			String forceString = request.getParameter("force");
			String lenghtString = request.getParameter("lenght");
			String lenghtxString = request.getParameter("lenghtX");
			if(selectMenu.contains("CHS")) {
//				Calculations calculations = new Calculations(selectMenu);
//				System.out.println(calculations.getInetria());
//				System.out.println(Calculations.getInetria(selectMenu));
				int force = Integer.parseInt(forceString);
				int lenght = Integer.parseInt(lenghtString);
				int lenghtX = Integer.parseInt(lenghtxString);
				Case1 case1 = new Case1(force, lenght, lenghtX, selectMenu);
				double number = case1.getInertia();
				System.out.println(number);
//				
			}
			
		}
		if (request.getSession().getAttribute(getServletInfo()).equals("case2")) {
			System.out.println("tova e case2");
		}
		if (request.getSession().getAttribute(getServletInfo()).equals("case3")) {
			System.out.println("tova e case3");
		}
		if (request.getSession().getAttribute(getServletInfo()).equals("case4")) {
			System.out.println("tova e case4");
		}
		if (request.getSession().getAttribute(getServletInfo()).equals("case5")) {
			System.out.println("tova e case5");
		}

	}

}
