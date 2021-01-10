package lab_02_09_20_Arrays;

import java.util.Random;
import java.util.Scanner;


public class Task_Hanger_WorkingVersion {
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String wordList [] = {"бесилка","локомотив","маймуна","гардероб","прозорец","акумулатор","катедрала","анатомия","обектив","абориген","хромозома","манатарка","контейнер",
				"уравнение","зъболекар","намаление","индикатор","пробиване","дъждобран","отпечатък","дървесина","галактика"};
		
		Random randomWord = new Random();
		int wordPos = randomWord.nextInt(wordList.length);		// Генениране на произволен номер (позиция) от листа с думи
		String wordToGuess = wordList[wordPos];					// Генениране на произволна дума от Листа с думи
		String censoredWord = "";
		for (int i = 0; i < wordToGuess.length(); i++) {		// Генериране на Стринг от '*' с брой равен на броя на буквите в избраната дума
			censoredWord += "*";
		}

		//String result [] = censoredWord.split(" ");				// Създаваме масив от стрингове, които са символите на цензурираната дума с премахнат интервал
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
		
		
// Цикъл да върти опитите за познаване на думата
		while (mistakes < 7 || isWordGuessed == true) {
			finalString = "";
			System.out.println("Въведи буква или дума: ");
			entry = scanner.nextLine();
			entryCharCount = 0;
			
// Проверка дали въведеното от потребителя е символ или дума (да има повече от 1 символ)
			for (int i = 0; i < entry.length(); i++) {								
				entryCharCount ++;
			}
// Ако въведеното от потребителя е дума
			if (entryCharCount > 1) {
				if (entry.equalsIgnoreCase(wordToGuess)) {
					isWordGuessed = true;
					break;
				}else{
					mistakes = 7;
				}
/* Ако въведеното от потребителя е символ
Проверка дали символа въведен от потребителя съществува в думата */
			}else {
				boolean isCharFound = false;
				for (int i = 0; i < wordToGuess.length(); i++) {
					if (wordToGuess.charAt(i) == entry.charAt(0) ) {
						result[i] = entry;
						isCharFound = true;
					}
				}
// Ако няма намерена буква в думата, увеличава грешките с +1
				if (!isCharFound) {
					mistakes++;
				}
			}
// Принтира какво се е разкрило от думата
			for (String symbol : result) {
				finalString += symbol + " ";
			}
			
			if (!finalString.contains("*")) {
				isWordGuessed = true;
				break;
			}else {
				System.out.println(finalString);
			}
			System.out.println("Грешки " + "(" + mistakes +")" );
			//System.out.println();
// Рисунки
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
// Край на WHILE цикъла
		
		if (isWordGuessed || mistakes < 7) {
			System.out.println();
			for (int i = 0; i < wordToGuess.length(); i++) {
				System.out.print(wordToGuess.charAt(i) + " ");
			}
			System.out.println();
			System.out.println();
			System.out.println("Ч Е С Т И Т О");
			System.out.println("Ти позна думата " + "'" + wordToGuess +"'");
		}else if (mistakes >= 7){
			System.out.println("Ти не позна думата "+ "'" + wordToGuess +"'" + " и беше обесен ");
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
