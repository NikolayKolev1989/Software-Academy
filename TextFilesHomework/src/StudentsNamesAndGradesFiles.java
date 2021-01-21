import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Ако в един файл съхранявате имена на ученици,
 *  а в друг техните оценки, създайте трети файл,
 *   чиито редове съдържат име и оценка на ученик,
 *    съотвестващи си по номер на ред в двата начални файла.
 */

public class StudentsNamesAndGradesFiles {
	public static void main(String[] args) throws FileNotFoundException {
		
		namesAndGrades();
		
	}
	
	public static void namesAndGrades() throws FileNotFoundException {
		PrintWriter writer = new PrintWriter("StudentsNamesAndGrades.txt");
		Scanner reader1 = new Scanner(new File("StudentsNames.txt"));
		Scanner reader2 = new Scanner(new File("StudentsGrades.txt"));
		
		
		
		while(reader1.hasNextLine()){
			StringBuilder sb = new StringBuilder();
			String reader1Word = reader1.nextLine();
			String reader2Word = reader2.nextLine();
			
			sb.append("name: " + reader1Word + " - ");
			sb.append("grade: " + reader2Word);
			
			writer.println(sb.toString());
		}
		
		reader1.close();
		reader2.close();
		writer.flush();
		writer.close();
	}
}
