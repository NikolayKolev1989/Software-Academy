import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Напишете програма, която обединява съдържанието на два файла,
 * съответно първо съдържаниято на единия файл и после 
 * съдържанието на другия файл. Променете първия файл.
 */

public class FilesCombo {
	public static void main(String[] args) throws FileNotFoundException {
		
		fileCombo();
		
		File file1 = new File("ComboFile01.txt");
		File tempFile = new File("temp.txt");
		file1.delete();
		tempFile.renameTo(new File("ComboFile01.txt"));
		
	}
	
	public static void fileCombo() throws FileNotFoundException {
		PrintWriter writer = new PrintWriter("temp.txt");
		Scanner reader1 = new Scanner(new File("ComboFile01.txt"));
		Scanner reader2 = new Scanner(new File("ComboFile02.txt"));
		
		while (reader1.hasNextLine()) {
			String text = reader1.nextLine();
			writer.println(text);
		}
		
		while (reader2.hasNextLine()) {
			String text = reader2.nextLine();
			writer.println(text);
		}
		
		reader1.close();
		reader2.close();
		writer.flush();
		writer.close();
		
	}
}
