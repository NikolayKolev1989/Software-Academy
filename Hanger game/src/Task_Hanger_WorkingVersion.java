package lab_02_09_20_Arrays;

import java.util.Random;
import java.util.Scanner;


public class Task_Hanger_WorkingVersion {
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String wordList [] = {"�������","���������","�������","��������","��������","����������","���������","��������","�������","��������","���������","���������","���������",
				"���������","���������","���������","���������","���������","���������","���������","���������","���������"};
		
		Random randomWord = new Random();
		int wordPos = randomWord.nextInt(wordList.length);		// ���������� �� ���������� ����� (�������) �� ����� � ����
		String wordToGuess = wordList[wordPos];					// ���������� �� ���������� ���� �� ����� � ����
		String censoredWord = "";
		for (int i = 0; i < wordToGuess.length(); i++) {		// ���������� �� ������ �� '*' � ���� ����� �� ���� �� ������� � ��������� ����
			censoredWord += "*";
		}

		//String result [] = censoredWord.split(" ");				// ��������� ����� �� ���������, ����� �� ��������� �� ������������� ���� � ��������� ��������
		int mistakes = 0;
		boolean isWordGuessed = false;
		String entry = "";
		int entryCharCount;
		
		System.out.println(wordToGuess);
		String result [] = new String [wordToGuess.length()];
		for (int i = 0; i < result.length; i++) {
			result [i] = "*";
			System.out.print(result[i] + " ");
		}
		String finalString;
		
		
// ����� �� ����� ������� �� ��������� �� ������
		while (mistakes < 7 || isWordGuessed == true) {
			finalString = "";
			System.out.println("������ ����� ��� ����: ");
			entry = scanner.nextLine();
			entryCharCount = 0;
			
// �������� ���� ���������� �� ����������� � ������ ��� ���� (�� ��� ������ �� 1 ������)
			for (int i = 0; i < entry.length(); i++) {								
				entryCharCount ++;
			}
// ��� ���������� �� ����������� � ����
			if (entryCharCount > 1) {
				if (entry.equalsIgnoreCase(wordToGuess)) {
					isWordGuessed = true;
					break;
				}else{
					mistakes = 7;
				}
/* ��� ���������� �� ����������� � ������
�������� ���� ������� ������� �� ����������� ���������� � ������ */
			}else {
				boolean isCharFound = false;
				for (int i = 0; i < wordToGuess.length(); i++) {
					if (wordToGuess.charAt(i) == entry.charAt(0) ) {
						result[i] = entry;
						isCharFound = true;
					}
				}
// ��� ���� �������� ����� � ������, ��������� �������� � +1
				if (!isCharFound) {
					mistakes++;
				}
			}
// �������� ����� �� � �������� �� ������
			for (String symbol : result) {
				finalString += symbol + " ";
			}
			
			if (!finalString.contains("*")) {
				isWordGuessed = true;
				break;
			}else {
				System.out.println(finalString);
			}
			System.out.println("������ " + "(" + mistakes +")" );
			//System.out.println();
// �������
			switch (mistakes) {
			case 1:
				mistake01Drawing();
				break;
			case 2:
				mistake02Drawing();
				break;
			case 3:
				mistake03Drawing();
				break;
			case 4:
				mistake04Drawing();
				break;
			case 5:
				mistake05Drawing();
				break;
			case 6:
				mistake06Drawing();
				break;
			case 7:
				mistake07Drawing();
				break;
			default:
				break;
			}
		}
// ���� �� WHILE ������
		
		if (isWordGuessed || mistakes < 7) {
			System.out.println();
			for (int i = 0; i < wordToGuess.length(); i++) {
				System.out.print(wordToGuess.charAt(i) + " ");
			}
			System.out.println();
			System.out.println();
			System.out.println("� � � � � � �");
			System.out.println("�� ����� ������ " + "'" + wordToGuess +"'");
		}else if (mistakes >= 7){
			System.out.println("�� �� ����� ������ "+ "'" + wordToGuess +"'" + " � ���� ������ ");
		}
	}
	
	
	
	
	
	public static void mistake01Drawing() {
		System.out.println(" ______");
		System.out.println("|      |");
		System.out.println("|      |");
		System.out.println("|");
		System.out.println("|");
		System.out.println("|");
		System.out.println("|");
		System.out.println("|");
		System.out.println();
	}
	public static void mistake02Drawing() {
		System.out.println(" ______");
		System.out.println("|      |");
		System.out.println("|      |");
		System.out.println("|      O");
		System.out.println("|");
		System.out.println("|");
		System.out.println("|");
		System.out.println("|");
		System.out.println();
	}
	public static void mistake03Drawing() {
		System.out.println(" ______");
		System.out.println("|      |");
		System.out.println("|      |");
		System.out.println("|      O");
		System.out.println("|      |");
		System.out.println("|      |");
		System.out.println("|");
		System.out.println("|");
		System.out.println();
	}
	public static void mistake04Drawing() {
		System.out.println(" ______");
		System.out.println("|      |");
		System.out.println("|      |");
		System.out.println("|      O");
		System.out.println("|     /|");
		System.out.println("|      |");
		System.out.println("|");
		System.out.println("|");
		System.out.println();
	}
	public static void mistake05Drawing() {
		System.out.println(" ______");
		System.out.println("|      |");
		System.out.println("|      |");
		System.out.println("|      O");
		System.out.println("|     /|\\");
		System.out.println("|      |");
		System.out.println("|");
		System.out.println("|");
		System.out.println();
	}
	public static void mistake06Drawing() {
		System.out.println(" ______");
		System.out.println("|      |");
		System.out.println("|      |");
		System.out.println("|      O");
		System.out.println("|     /|\\");
		System.out.println("|      |");
		System.out.println("|     /");
		System.out.println("|");
		System.out.println();
	}
	public static void mistake07Drawing() {
		System.out.println(" ______");
		System.out.println("|      |");
		System.out.println("|      |");
		System.out.println("|      O");
		System.out.println("|     /|\\");
		System.out.println("|      |");
		System.out.println("|     / \\");
		System.out.println("|");
		System.out.println();
	}
	
	
	
}
