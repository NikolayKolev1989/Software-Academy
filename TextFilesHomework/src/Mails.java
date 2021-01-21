import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Mails {
	public static void main(String[] args) throws FileNotFoundException {

		removeDublicates();

		File file1 = new File("Mails.txt");
		File tempFile = new File("tempMails.txt");
		file1.delete();
		tempFile.renameTo(new File("Mails.txt"));

	}

	public static void removeDublicates() throws FileNotFoundException {
		PrintWriter writer = new PrintWriter("tempMails.txt");
		Scanner reader = new Scanner(new File("Mails.txt"));

		while (reader.hasNextLine()) {
			String mailToDelete = reader.nextLine();
			boolean mailAlreadyThere = false;
			while (reader.hasNextLine()) {
				String mailToCompare = reader.nextLine();
				
				if (!mailAlreadyThere) {
					writer.println(mailToCompare);
				} else {
					reader.nextLine();
				}
				
				if (mailToDelete.equals(mailToCompare)) {
					mailAlreadyThere = true;
				}
			}
		}

		reader.close();
		writer.flush();
		writer.close();
	}
}
