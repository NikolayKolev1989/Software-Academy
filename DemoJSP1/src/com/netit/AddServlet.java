package com.netit;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/add")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("num1") != null && request.getParameter("num2") != null){
		 	int number1 = Integer.parseInt(request.getParameter("num1"));
			int number2 = Integer.parseInt(request.getParameter("num2"));
			int result = number1 + number2;
			request.setAttribute("num1", number1);
			request.setAttribute("num2", number2);
			request.setAttribute("res", result);
		}
		request.getRequestDispatcher("add.jsp").forward(request, response);
		
	}

}
