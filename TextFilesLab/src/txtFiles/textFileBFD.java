package txtFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

//CRUD - Creata Read Update Delete

public class textFileBFD {
	public static void main(String[] args) throws FileNotFoundException {
//		addRow(2, 2);
//		changeRow(2, 0);
//		delRow(2);
		addNumber(5);
//		changeNumber(5, 6);
//		delNumber(6);

		File file1 = new File("digits.txt");
		file1.delete();
		File file2 = new File("temp.txt");
		file2.renameTo(new File("digits.txt"));

	}

	public static void addRow(int row, int newNumber) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter("temp.txt");
		Scanner reader = new Scanner(new File("digits.txt"));

		int count = 0;
		while (reader.hasNextLine()) {
			count++;
			if (count == row) {
				writer.println(newNumber);
			} else {
				String number = reader.nextLine();
				writer.println(number);
			}
		}

		reader.close();
		writer.flush();
		writer.close();
	}

	public static void changeRow(int row, int newNumber) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter("temp.txt");
		Scanner reader = new Scanner(new File("digits.txt"));

		int count = 0;
		while (reader.hasNextLine()) {
			count++;
			if (count == row) {
				writer.println(newNumber);
				reader.nextLine();
			} else {
				String number = reader.nextLine();
				writer.println(number);
			}
		}

		reader.close();
		writer.flush();
		writer.close();
	}

	public static void delRow(int row) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter("temp.txt");
		Scanner reader = new Scanner(new File("digits.txt"));

		int count = 0;
		while (reader.hasNextLine()) {
			count++;
			if (count == row) {
				reader.nextLine();
			} else {
				String number = reader.nextLine();
				writer.println(number);
			}
		}

		reader.close();
		writer.flush();
		writer.close();
	}

	public static void addNumber(int newNumber) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter("temp.txt");
		Scanner reader = new Scanner(new File("digits.txt"));
		boolean inserted = false;
		while (reader.hasNextLine()) {
			String number = reader.nextLine();
			int readNumber = Integer.parseInt(number);
			if (newNumber <= readNumber && !inserted) {
				writer.println(newNumber);
				inserted = true;
			}
			writer.println(number);

		}
		if (!inserted) {
			writer.println(newNumber);
		}
		reader.close();
		writer.flush();
		writer.close();
	}

	public static void changeNumber(int oldNumber, int newNumber) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter("temp.txt");
		Scanner reader = new Scanner(new File("digits.txt"));

		while (reader.hasNextLine()) {
			String number = reader.nextLine();
			int readNumber = Integer.parseInt(number);
			if (oldNumber == readNumber) {
				writer.println(newNumber);
			} else {
				writer.println(number);
			}

		}

		reader.close();
		writer.flush();
		writer.close();
	}

	public static void delNumber(int oldNumber) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter("temp.txt");
		Scanner reader = new Scanner(new File("digits.txt"));
		while (reader.hasNextLine()) {
			String number = reader.nextLine();
			int readNumber = Integer.parseInt(number);
			if (oldNumber != readNumber) {
				writer.println(number);
			}
			

		}
		
		reader.close();
		writer.flush();
		writer.close();
	}
}
