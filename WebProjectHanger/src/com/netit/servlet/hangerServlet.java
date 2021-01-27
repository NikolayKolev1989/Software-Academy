package com.netit.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.HangerWebVersion;
import main.Task_Hanger_WorkingVersion;

/**
 * Servlet implementation class hangerServlet
 */
@WebServlet("/hanger")

public class hangerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HangerWebVersion hanger = new HangerWebVersion();
	private int mista�eCounter = 0;
	private String wordToGuess;
	private String result[];
	private String finalString = "";
	private boolean isWordGuessed = false;
	private static String wordList[] = { "�������", "���������", "�������", "��������", "��������", "����������",
			"���������", "��������", "�������", "��������", "���������", "���������", "���������", "���������",
			"���������", "���������", "���������", "���������", "���������", "���������", "���������", "���������" };

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public hangerServlet() {
		super();
		Random randomWord = new Random();
		int wordPos = randomWord.nextInt(wordList.length); // ���������� �� ���������� ����� (�������) �� ����� � ����
		wordToGuess = wordList[wordPos];
		System.out.println(wordToGuess);

		result = new String[wordToGuess.length()]; // ��������� �� ����� �� * � ������� ������ �� ���������
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
		System.out.println(wordToGuess);

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

		// �������� ���� ������� ������� �� ����������� ���������� � ������
		boolean isCharFound = false;
		for (int i = 0; i < wordToGuess.length(); i++) {
			if (wordToGuess.charAt(i) == entry.charAt(0)) {
				result[i] = entry;
				isCharFound = true;
			}
		}
		
		// ��� ���� �������� ����� � ������, ��������� �������� � +1
		if (!isCharFound) {
			mista�eCounter++;
		}
		
		// �������� ����� �� � �������� �� ������
		finalString="";
		for (String symbol : result) {
			finalString += symbol + " ";
		}
		
		// ��������� ���� �� �������� ������ ���������
		if (!finalString.contains("*")) {
			isWordGuessed = true;
		} else {
			System.out.println(finalString);
		}
		System.out.println("������ " + "(" + mista�eCounter + ")");
	}
}
