package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class caseTypeServlet
 */
@WebServlet("/caseTypeServlet")
public class caseTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public caseTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		
//		STORE THE CASE NUMBER, BECAUSE THE casesServlet CALCULATION DEPENDS OF THIS
		String option = "";
		String hiddenInput = (String) request.getParameter("hiddenInput");
		request.getSession().setAttribute(option, hiddenInput);
//		System.out.println("hidden -> " + hidden);
//		System.out.println("option -> " + request.getSession().getAttribute(option));
		
//		CHOOSE WHICH JSP PAGE TO SHOW
		if (request.getSession().getAttribute(option).equals("case1")) {
			response.sendRedirect("case1.jsp");
		}
		if (request.getSession().getAttribute(option).equals("case2")) {
			response.sendRedirect("case2.jsp");
		}
		if (request.getSession().getAttribute(option).equals("case3")) {
			response.sendRedirect("case3.jsp");
		}
		if (request.getSession().getAttribute(option).equals("case4")) {
			response.sendRedirect("case4.jsp");
		}
		if (request.getSession().getAttribute(option).equals("case5")) {
			response.sendRedirect("case5.jsp");
		}
	}

}
