//import java.io.BufferedInputStream;
import java.io.EOFException;
//import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ChemistryData {

	final int [] dataMax = {35,55,72,75,45,100};
	int[][] data = new int[6][10];
	File readfile;
	DataInputStream in;
	String errors = "";
	
	public ChemistryData(String file) {
		readFile(file);
	}
	
	public void readFile(String file) {
		
		try {
			readfile = new File(file);
			int validateData = 0;
			boolean valid = false;
			in = new DataInputStream(new FileInputStream(readfile));

			for (int r=0;r<6;r++) {
				for (int c=0;c<10;c++) {
					validateData = in.readInt();
					valid = checkData(validateData,r);
					while (!valid) {
						maxError(validateData);
						validateData = in.readInt();
						valid = checkData(validateData,r);
					}
					data[r][c] = validateData;
				}
			}
			in.close();
		}
		catch (EOFException e) {
			System.out.println(e.getMessage());
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	public boolean checkData(int data, int row) {
		
		boolean valid = false;
		if (row==0 && data<=dataMax[0]) {
			valid = true;
		}
		if (row==1 && data<=dataMax[1]) {
			valid = true;
		}
		if (row==2 && data<=dataMax[2]) {
			valid = true;
		}
		if (row==3 && data<=dataMax[3]) {
			valid = true;
		}
		if (row==4 && data<=dataMax[4]) {
			valid = true;
		}
		if (row==5 && data<=dataMax[5]) {
			valid = true;
		}
		return valid;
	}
	
	public void maxError(int data) {
		
		try {
			
			throw new MaxDataException();
		}
		catch (MaxDataException e) {
			errors += +data +" - "+e.getMessage()+"\n";
		}
	}
}
