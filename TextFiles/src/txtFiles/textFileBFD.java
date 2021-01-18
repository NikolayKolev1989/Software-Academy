package txtFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class textFileBFD {
	public static void main(String[] args) throws FileNotFoundException {
		addRow(2, 2);
		
		File file1 = new File("digits.txt");
		file1.delete();
		File file2 = new File("temp.txt");
		file2.renameTo(new File("digits.txt"));
		
//		changeRow(2, 2);
		
	}
	
	public static void addRow (int row, int newNumber) throws FileNotFoundException {
//		CRUD - Creata Read Update Delete
		PrintWriter writer = new PrintWriter ("temp.txt");
		Scanner reader = new Scanner(new File ("digits.txt"));
		
		int count = 0;
		while(reader.hasNextLine()) {
			count++;
			if (count == row) {
				writer.println(newNumber);
			}else {
				String number = reader.nextLine();
				writer.println(number);
			}
		}
		
		reader.close();
		writer.flush();
		writer.close();
	}
	
	public static void changeRow (int row, int newNumber) throws FileNotFoundException {
//		CRUD - Creata Read Update Delete
		PrintWriter writer = new PrintWriter ("temp.txt");
		Scanner reader = new Scanner(new File ("digits.txt"));
		
		int count = 0;
		while(reader.hasNextLine()) {
			count++;
			if (count == row) {
				writer.println(newNumber);
				reader.nextLine();
			}else {
				String number = reader.nextLine();
				writer.println(number);
			}
		}
		
		reader.close();
		writer.flush();
		writer.close();
	}
}

