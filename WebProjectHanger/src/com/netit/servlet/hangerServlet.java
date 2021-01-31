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
			"cathedral", "anatomy", "objective", "chromosome", "container", "equation", "dentist", "discount",
			"indicator", "puncture", "raincoat", "fingerprint" };
	private String usedCharacters = "";
	private PrintWriter out;

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
		resultMistakes0();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		out = response.getWriter();
//		request.getRequestDispatcher("game.html").forward(request, response);
		String entry = request.getParameter("charToGuess");
		System.out.println(entry);
		usedCharacters += entry + ", ";

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
		resultToString = "";
		for (String symbol : result) {
			resultToString += symbol + " ";
		}
		resultToString = resultToString.toUpperCase();

		// Проверява дали са разкрити всички звездички
		if (!resultToString.contains("*")) {
			isWordGuessed = true;
		} else {
			System.out.println(resultToString);
		}
		System.out.println("Грешки " + "(" + mistaкeCounter + ")");

		switch (mistaкeCounter) {
		case 0:
			resultMistakes0();
			break;
		case 1:
			resultMistakes1();
			break;
		case 2:
			resultMistakes2();
			break;
		case 3:
			resultMistakes3();
			break;
		case 4:
			resultMistakes4();
			break;
		case 5:
			resultMistakes5();
			break;
		case 6:
			resultMistakes6();
			break;
		case 7:
			resultMistakes7();
			break;

		default:
			break;
		}

//		response.getOutputStream().print("<!DOCTYPE html>\r\n"
//		+ "<html>\r\n"
//		+ "	<head>\r\n"
//		+ "	<meta charset=\"UTF-8\">\r\n"
//		+ "	<title>Hanger</title>\r\n"
//		+ "	</head>\r\n"
//		+ "	<body bgcolor=\"lightblue\">\r\n"
//		+ "		<form method=\"post\" action=\"hanger\">\r\n"
//		+ "			<table width=\"25%\">\r\n"
//		+ "				<thead>\r\n"
//		+ "					<tr>\r\n"
//		+ "                   <!-- <th></th>\r\n"
//		+ "						<th colspan=\"1\" align=\"center\"><h2>Hanger</h2></th> -->\r\n"
//		+ "						<th colspan=\"2\" align=\"right\"><h2>Hanger</h2></th>\r\n"
//		+ "				</tr>\r\n"
//		+ "				</thead>\r\n"
//		+ "				<tbody>\r\n"
//		+ "					<tr>\r\n"
//		+ "						<td align=\"right\" >Enter character:</td>\r\n"
//		+ "						<td align=\"center\"><input type=\"text\" name=\"charToGuess\" id=\"charToGuess\" maxlength=\"1\" size=\"5\"></td>\r\n"
//		+ "						<td align=\"left\" rowspan=\"2\"><textarea rows=\"5\" cols=\"22\" name=\"history\" readonly=\"readonly\">" + resultToString + "</textarea></td>\r\n"
//		+ "					</tr>\r\n"
//		+ "					<tr>\r\n"
//		+ "						<td></td>\r\n"
//		+ "						<td align=\"center\"><input type=\"submit\" name=\"checkButton\" value=\"Check\" ></td>\r\n"
//		+ "					</tr>\r\n"
//		+ "				</tbody>\r\n"
//		+ "			</table>\r\n"
//		+ "		</form>\r\n"
//		+ "	</body>\r\n"
//		+ "</html>");

//		response.getOutputStream().flush();
//		response.getOutputStream().close();
//		out.flush();
//		out.close();

//		response.sendRedirect("game.html");

	}

	public void resultMistakes0() {
		out.append("<!DOCTYPE html>");
		out.append("<html>");
		out.append("<head>");
		out.append("<meta charset=\"UTF-8\">");
		out.append("<title>Hanger</title>");
		out.append("</head>");
		out.append("<body bgcolor=\"lightblue\">");
		out.append("<form method=\"post\" action=\"hanger\">");
		out.append("<table width=\"100%\">");
		out.append("<thead>");
		out.append("<tr>");
		out.append("<th colspan=\"4\" align=\"right\"><h2>Hanger game</h2></th>");
		out.append("</tr>");
		out.append("</thead>");
		out.append("<tbody>");
		out.append("<tr>");
		out.append("<td align=\"right\" valign=\"baseline\" colspan=\"2\">Enter character:</td>");
		out.append("<td align=\"left\" valign=\"baseline\" colspan=\"2\"><input type=\"text\" name=\"charToGuess\" id=\"charToGuess\" maxlength=\"1\" size=\"5\"></td>");
		out.append("<td><label><b>Mistakes: "+ mistaкeCounter +"</b> </label></td>");
		out.append("</tr>");
		out.append("<tr>");
		out.append("<td></td>");
		out.append("<td align=\"center\" valign=\"baseline\" colspan=\"2\"><input type=\"submit\" name=\"checkButton\" value=\"Check\" ></td>");
		out.append("<td></td>");
		out.append("<td><label><b>Word: "+ resultToString +"</b></label></td>");
		out.append("</tr>");
		out.append("<tr>");
		out.append("<td colspan=\"4\" align=\"center\"><label><b>Used characters: "+ usedCharacters +"</b></label></td>");
		out.append("<td align=\"left\" rowspan=\"15\"><img src=\"Images/hangerDefault.png\" alt=\"image not found\"></td>");
		out.append("</tr>");
		out.append("</tbody>");
		out.append("</table>");
		out.append("</form>");
		out.append("</body>");
		out.append("</html>");

	}

	public void resultMistakes1() {
		out.append("<!DOCTYPE html>");
		out.append("<html>");
		out.append("<head>");
		out.append("<meta charset=\"UTF-8\">");
		out.append("<title>Hanger</title>");
		out.append("</head>");
		out.append("<body bgcolor=\"lightblue\">");
		out.append("<form method=\"post\" action=\"hanger\">");
		out.append("<table width=\"100%\">");
		out.append("<thead>");
		out.append("<tr>");
		out.append("<th colspan=\"4\" align=\"right\"><h2>Hanger game</h2></th>");
		out.append("</tr>");
		out.append("</thead>");
		out.append("<tbody>");
		out.append("<tr>");
		out.append("<td align=\"right\" valign=\"baseline\" colspan=\"2\">Enter character:</td>");
		out.append("<td align=\"left\" valign=\"baseline\" colspan=\"2\"><input type=\"text\" name=\"charToGuess\" id=\"charToGuess\" maxlength=\"1\" size=\"5\"></td>");
		out.append("<td><label><b>Mistakes: "+ mistaкeCounter +"</b> </label></td>");
		out.append("</tr>");
		out.append("<tr>");
		out.append("<td></td>");
		out.append("<td align=\"center\" valign=\"baseline\" colspan=\"2\"><input type=\"submit\" name=\"checkButton\" value=\"Check\" ></td>");
		out.append("<td></td>");
		out.append("<td><label><b>Word: "+ resultToString +"</b></label></td>");
		out.append("</tr>");
		out.append("<tr>");
		out.append("<td colspan=\"4\" align=\"center\"><label><b>Used characters: "+ usedCharacters +"</b></label></td>");
		out.append("<td align=\"left\" rowspan=\"15\"><img src=\"Images/hangerMistake1.png\" alt=\"image not found\"></td>");
		out.append("</tr>");
		out.append("</tbody>");
		out.append("</table>");
		out.append("</form>");
		out.append("</body>");
		out.append("</html>");
	}

	public void resultMistakes2() {
		out.append("<!DOCTYPE html>");
		out.append("<html>");
		out.append("<head>");
		out.append("<meta charset=\"UTF-8\">");
		out.append("<title>Hanger</title>");
		out.append("</head>");
		out.append("<body bgcolor=\"lightblue\">");
		out.append("<form method=\"post\" action=\"hanger\">");
		out.append("<table width=\"100%\">");
		out.append("<thead>");
		out.append("<tr>");
		out.append("<th colspan=\"4\" align=\"right\"><h2>Hanger game</h2></th>");
		out.append("</tr>");
		out.append("</thead>");
		out.append("<tbody>");
		out.append("<tr>");
		out.append("<td align=\"right\" valign=\"baseline\" colspan=\"2\">Enter character:</td>");
		out.append("<td align=\"left\" valign=\"baseline\" colspan=\"2\"><input type=\"text\" name=\"charToGuess\" id=\"charToGuess\" maxlength=\"1\" size=\"5\"></td>");
		out.append("<td><label><b>Mistakes: "+ mistaкeCounter +"</b> </label></td>");
		out.append("</tr>");
		out.append("<tr>");
		out.append("<td></td>");
		out.append("<td align=\"center\" valign=\"baseline\" colspan=\"2\"><input type=\"submit\" name=\"checkButton\" value=\"Check\" ></td>");
		out.append("<td></td>");
		out.append("<td><label><b>Word: "+ resultToString +"</b></label></td>");
		out.append("</tr>");
		out.append("<tr>");
		out.append("<td colspan=\"4\" align=\"center\"><label><b>Used characters: "+ usedCharacters +"</b></label></td>");
		out.append("<td align=\"left\" rowspan=\"15\"><img src=\"Images/hangerMistake2.png\" alt=\"image not found\"></td>");
		out.append("</tr>");
		out.append("</tbody>");
		out.append("</table>");
		out.append("</form>");
		out.append("</body>");
		out.append("</html>");
	}

	public void resultMistakes3() {
		out.append("<!DOCTYPE html>");
		out.append("<html>");
		out.append("<head>");
		out.append("<meta charset=\"UTF-8\">");
		out.append("<title>Hanger</title>");
		out.append("</head>");
		out.append("<body bgcolor=\"lightblue\">");
		out.append("<form method=\"post\" action=\"hanger\">");
		out.append("<table width=\"100%\">");
		out.append("<thead>");
		out.append("<tr>");
		out.append("<th colspan=\"4\" align=\"right\"><h2>Hanger game</h2></th>");
		out.append("</tr>");
		out.append("</thead>");
		out.append("<tbody>");
		out.append("<tr>");
		out.append("<td align=\"right\" valign=\"baseline\" colspan=\"2\">Enter character:</td>");
		out.append("<td align=\"left\" valign=\"baseline\" colspan=\"2\"><input type=\"text\" name=\"charToGuess\" id=\"charToGuess\" maxlength=\"1\" size=\"5\"></td>");
		out.append("<td><label><b>Mistakes: "+ mistaкeCounter +"</b> </label></td>");
		out.append("</tr>");
		out.append("<tr>");
		out.append("<td></td>");
		out.append("<td align=\"center\" valign=\"baseline\" colspan=\"2\"><input type=\"submit\" name=\"checkButton\" value=\"Check\" ></td>");
		out.append("<td></td>");
		out.append("<td><label><b>Word: "+ resultToString +"</b></label></td>");
		out.append("</tr>");
		out.append("<tr>");
		out.append("<td colspan=\"4\" align=\"center\"><label><b>Used characters: "+ usedCharacters +"</b></label></td>");
		out.append("<td align=\"left\" rowspan=\"15\"><img src=\"Images/hangerMistake3.png\" alt=\"image not found\"></td>");
		out.append("</tr>");
		out.append("</tbody>");
		out.append("</table>");
		out.append("</form>");
		out.append("</body>");
		out.append("</html>");
	}

	public void resultMistakes4() {
		out.append("<!DOCTYPE html>");
		out.append("<html>");
		out.append("<head>");
		out.append("<meta charset=\"UTF-8\">");
		out.append("<title>Hanger</title>");
		out.append("</head>");
		out.append("<body bgcolor=\"lightblue\">");
		out.append("<form method=\"post\" action=\"hanger\">");
		out.append("<table width=\"100%\">");
		out.append("<thead>");
		out.append("<tr>");
		out.append("<th colspan=\"4\" align=\"right\"><h2>Hanger game</h2></th>");
		out.append("</tr>");
		out.append("</thead>");
		out.append("<tbody>");
		out.append("<tr>");
		out.append("<td align=\"right\" valign=\"baseline\" colspan=\"2\">Enter character:</td>");
		out.append("<td align=\"left\" valign=\"baseline\" colspan=\"2\"><input type=\"text\" name=\"charToGuess\" id=\"charToGuess\" maxlength=\"1\" size=\"5\"></td>");
		out.append("<td><label><b>Mistakes: "+ mistaкeCounter +"</b> </label></td>");
		out.append("</tr>");
		out.append("<tr>");
		out.append("<td></td>");
		out.append("<td align=\"center\" valign=\"baseline\" colspan=\"2\"><input type=\"submit\" name=\"checkButton\" value=\"Check\" ></td>");
		out.append("<td></td>");
		out.append("<td><label><b>Word: "+ resultToString +"</b></label></td>");
		out.append("</tr>");
		out.append("<tr>");
		out.append("<td colspan=\"4\" align=\"center\"><label><b>Used characters: "+ usedCharacters +"</b></label></td>");
		out.append("<td align=\"left\" rowspan=\"15\"><img src=\"Images/hangerMistake4.png\" alt=\"image not found\"></td>");
		out.append("</tr>");
		out.append("</tbody>");
		out.append("</table>");
		out.append("</form>");
		out.append("</body>");
		out.append("</html>");
	}

	public void resultMistakes5() {
		out.append("<!DOCTYPE html>");
		out.append("<html>");
		out.append("<head>");
		out.append("<meta charset=\"UTF-8\">");
		out.append("<title>Hanger</title>");
		out.append("</head>");
		out.append("<body bgcolor=\"lightblue\">");
		out.append("<form method=\"post\" action=\"hanger\">");
		out.append("<table width=\"100%\">");
		out.append("<thead>");
		out.append("<tr>");
		out.append("<th colspan=\"4\" align=\"right\"><h2>Hanger game</h2></th>");
		out.append("</tr>");
		out.append("</thead>");
		out.append("<tbody>");
		out.append("<tr>");
		out.append("<td align=\"right\" valign=\"baseline\" colspan=\"2\">Enter character:</td>");
		out.append("<td align=\"left\" valign=\"baseline\" colspan=\"2\"><input type=\"text\" name=\"charToGuess\" id=\"charToGuess\" maxlength=\"1\" size=\"5\"></td>");
		out.append("<td><label><b>Mistakes: "+ mistaкeCounter +"</b> </label></td>");
		out.append("</tr>");
		out.append("<tr>");
		out.append("<td></td>");
		out.append("<td align=\"center\" valign=\"baseline\" colspan=\"2\"><input type=\"submit\" name=\"checkButton\" value=\"Check\" ></td>");
		out.append("<td></td>");
		out.append("<td><label><b>Word: "+ resultToString +"</b></label></td>");
		out.append("</tr>");
		out.append("<tr>");
		out.append("<td colspan=\"4\" align=\"center\"><label><b>Used characters: "+ usedCharacters +"</b></label></td>");
		out.append("<td align=\"left\" rowspan=\"15\"><img src=\"Images/hangerMistake5.png\" alt=\"image not found\"></td>");
		out.append("</tr>");
		out.append("</tbody>");
		out.append("</table>");
		out.append("</form>");
		out.append("</body>");
		out.append("</html>");
	}

	public void resultMistakes6() {
		out.append("<!DOCTYPE html>");
		out.append("<html>");
		out.append("<head>");
		out.append("<meta charset=\"UTF-8\">");
		out.append("<title>Hanger</title>");
		out.append("</head>");
		out.append("<body bgcolor=\"lightblue\">");
		out.append("<form method=\"post\" action=\"hanger\">");
		out.append("<table width=\"100%\">");
		out.append("<thead>");
		out.append("<tr>");
		out.append("<th colspan=\"4\" align=\"right\"><h2>Hanger game</h2></th>");
		out.append("</tr>");
		out.append("</thead>");
		out.append("<tbody>");
		out.append("<tr>");
		out.append("<td align=\"right\" valign=\"baseline\" colspan=\"2\">Enter character:</td>");
		out.append("<td align=\"left\" valign=\"baseline\" colspan=\"2\"><input type=\"text\" name=\"charToGuess\" id=\"charToGuess\" maxlength=\"1\" size=\"5\"></td>");
		out.append("<td><label><b>Mistakes: "+ mistaкeCounter +"</b> </label></td>");
		out.append("</tr>");
		out.append("<tr>");
		out.append("<td></td>");
		out.append("<td align=\"center\" valign=\"baseline\" colspan=\"2\"><input type=\"submit\" name=\"checkButton\" value=\"Check\" ></td>");
		out.append("<td></td>");
		out.append("<td><label><b>Word: "+ resultToString +"</b></label></td>");
		out.append("</tr>");
		out.append("<tr>");
		out.append("<td colspan=\"4\" align=\"center\"><label><b>Used characters: "+ usedCharacters +"</b></label></td>");
		out.append("<td align=\"left\" rowspan=\"15\"><img src=\"Images/hangerMistake6.png\" alt=\"image not found\"></td>");
		out.append("</tr>");
		out.append("</tbody>");
		out.append("</table>");
		out.append("</form>");
		out.append("</body>");
		out.append("</html>");
	}

	public void resultMistakes7() {
		out.append("<!DOCTYPE html>");
		out.append("<html>");
		out.append("<head>");
		out.append("<meta charset=\"UTF-8\">");
		out.append("<title>Hanger</title>");
		out.append("</head>");
		out.append("<body bgcolor=\"lightblue\">");
		out.append("<form method=\"post\" action=\"hanger\">");
		out.append("<table width=\"100%\">");
		out.append("<thead>");
		out.append("<tr>");
		out.append("<th colspan=\"4\" align=\"right\"><h2>Hanger game</h2></th>");
		out.append("</tr>");
		out.append("</thead>");
		out.append("<tbody>");
		out.append("<tr>");
		out.append("<td align=\"right\" valign=\"baseline\" colspan=\"2\">Enter character:</td>");
		out.append("<td align=\"left\" valign=\"baseline\" colspan=\"2\"><input type=\"text\" name=\"charToGuess\" id=\"charToGuess\" maxlength=\"1\" size=\"5\"></td>");
		out.append("<td><label><b>Mistakes: "+ mistaкeCounter +"</b> </label></td>");
		out.append("</tr>");
		out.append("<tr>");
		out.append("<td></td>");
		out.append("<td align=\"center\" valign=\"baseline\" colspan=\"2\"><input type=\"submit\" name=\"checkButton\" value=\"Check\" ></td>");
		out.append("<td></td>");
		out.append("<td><label><b>Word: "+ resultToString +"</b></label></td>");
		out.append("</tr>");
		out.append("<tr>");
		out.append("<td colspan=\"4\" align=\"center\"><label><b>Used characters: "+ usedCharacters +"</b></label></td>");
		out.append("<td align=\"left\" rowspan=\"15\"><img src=\"Images/hangerMistake7.png\" alt=\"image not found\"></td>");
		out.append("</tr>");
		out.append("</tbody>");
		out.append("</table>");
		out.append("</form>");
		out.append("</body>");
		out.append("</html>");
	}
}
