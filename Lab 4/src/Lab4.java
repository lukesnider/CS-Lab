
import java.util.*;

public class Lab4 {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter a filename ");
		String file = keyboard.next();
		ChemistryData string = new ChemistryData(file);
		System.out.println(string.filecontents);
		
		

	}

}
