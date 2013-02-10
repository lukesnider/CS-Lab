
import java.util.*;

public class Lab4 {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter a filename ");
		String file = keyboard.next();
		ChemistryData string = new ChemistryData(file);

		int count = 0;
		for (int r=0;r<6;r++) {
			for (int c=0;c<10;c++) {
				System.out.println(string.data[r][c]);
				count++;
			}
		}
		System.out.println("\n"+count);

	}

}
