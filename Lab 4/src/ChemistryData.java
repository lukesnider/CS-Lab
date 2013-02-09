import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ChemistryData {
	
	File newfile;
	DataInputStream in;
	String filecontents;
	public ChemistryData(String file) {
		readFile(file);
	}
	
	public void readFile(String file) {
		int count = 0;
		try {
			newfile = new File(file);
			in = new DataInputStream(new BufferedInputStream(
                    new FileInputStream(newfile)));
			while (count < in.available()) {
				filecontents = filecontents +"\n"+in.readInt();
			}
			in.close();
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
