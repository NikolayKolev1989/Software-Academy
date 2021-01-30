package com.netit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class hangerServlet
 */
@WebServlet("/hanger")

public class hangerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int mistaкeCounter = 0;
	private String wordToGuess;
	private String result[];
	private String resultToString = "";
	private boolean isWordGuessed = false;
	private static String wordList[] = { "hanger", "locomotive", "monkey", "wardrobe", "window", "accumulator",
			"cathedral", "anatomy", "objective", "chromosome", "container", "equation",
			"dentist", "discount", "indicator", "puncture", "raincoat", "fingerprint"};


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public hangerServlet() {
		super();
		Random randomWord = new Random();
		int wordPos = randomWord.nextInt(wordList.length); // Генениране на произволен номер (позиция) от листа с думи
		wordToGuess = wordList[wordPos];
		System.out.println(wordToGuess);

		result = new String[wordToGuess.length()]; // Създаване на масив от * с дължина думата за познаване
		for (int i = 0; i < result.length; i++) {
			result[i] = "*";
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("game.html").forward(request, response);
//		System.out.println(wordToGuess);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("game.html").forward(request, response);
		String entry = request.getParameter("charToGuess");
		System.out.println(entry);
		PrintWriter out = response.getWriter();

		// Проверка дали символа въведен от потребителя съществува в думата
		boolean isCharFound = false;
		for (int i = 0; i < wordToGuess.length(); i++) {
			if (wordToGuess.charAt(i) == entry.charAt(0)) {
				result[i] = entry;
				isCharFound = true;
			}
		}
		
		// Ако няма намерена буква в думата, увеличава грешките с +1
		if (!isCharFound) {
			mistaкeCounter++;
		}
		
		// Принтира какво се е разкрило от думата
		resultToString="";
		for (String symbol : result) {
			resultToString += symbol + " ";
		}
		
		// Проверява дали са разкрити всички звездички
		if (!resultToString.contains("*")) {
			isWordGuessed = true;
		} else {
			System.out.println(resultToString);
		}
		System.out.println("Грешки " + "(" + mistaкeCounter + ")");
		
		out.append("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "	<head>\r\n"
				+ "	<meta charset=\"UTF-8\">\r\n"
				+ "	<title>Hanger</title>\r\n"
				+ "	</head>\r\n"
				+ "	<body bgcolor=\"lightblue\">\r\n"
				+ "		<form method=\"post\" action=\"hanger\">\r\n"
				+ "			<table width=\"25%\">\r\n"
				+ "				<thead>\r\n"
				+ "					<tr>\r\n"
				+ "                  	<th colspan=\"2\" align=\"right\"><h2>Hanger</h2></th>\r\n"
				+ "				</tr>\r\n"
				+ "				</thead>\r\n"
				+ "				<tbody>\r\n"
				+ "					<tr>\r\n"
				+ "						<td align=\"right\" >Enter character:</td>\r\n"
				+ "						<td align=\"center\"><input type=\"text\" name=\"charToGuess\" id=\"charToGuess\" maxlength=\"1\" size=\"5\"></td>\r\n"
				+ "						<td align=\"left\" rowspan=\"2\"><textarea rows=\"5\" cols=\"22\" name=\"history\" readonly=\"readonly\"> " + resultToString + "</textarea></td>\r\n"
				+ "					</tr>\r\n"
				+ "					<tr>\r\n"
				+ "						<td></td>\r\n"
				+ "						<td align=\"center\"><input type=\"submit\" name=\"checkButton\" value=\"Check\" ></td>\r\n"
				+ "					</tr>\r\n"
				+ "				</tbody>\r\n"
				+ "			</table>\r\n"
				+ "		</form>\r\n"
				+ "	</body>\r\n"
				+ "</html>");
		
	}
}






