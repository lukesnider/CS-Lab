import java.io.EOFException;
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
	int errorCount=0;
	
	public ChemistryData(String file) {
		assignData(file);
	}
	
	public void assignData(String file) {
		
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
		if (row==0 && data<=dataMax[0]&& data>0) {
			valid = true;
		}
		if (row==1 && data<=dataMax[1]&& data>0) {
			valid = true;
		}
		if (row==2 && data<=dataMax[2]&& data>0) {
			valid = true;
		}
		if (row==3 && data<=dataMax[3]&& data>0) {
			valid = true;
		}
		if (row==4 && data<=dataMax[4]&& data>0) {
			valid = true;
		}
		if (row==5 && data<=dataMax[5]&& data>0) {
			valid = true;
		}
		
		else {
			if (data<0) {
				try {
					throw new NegativeNumberException();
				}
				catch (NegativeNumberException e) {
					errors += +data+" - "+e.getMessage()+"\n";
					errorCount++;
				}
			}
			if (data>=dataMax[row]) {
				try {
					
					throw new MaxDataException();
				}
				catch (MaxDataException e) {
					errors += +data +" - "+e.getMessage()+dataMax[row]+"\n";
					errorCount++;
				}
			}
		}
		
		return valid;
	}
	
	public int rowAverage(int row) {
		int average=0;
		for (int c=0;c<10;c++) {
			average += data[row][c];
		}
		average = average/10;
		return average;
	}
	
	public String toString() {
		
		String string = "";
		
		string = errors+"\n"+"There were "+errorCount+" errors found in the data"+
		"Chemistry Experiments Report\n"+
		"Test#\tMax Data Point\tAverage Data Point\n"+
				"1\t"+dataMax[0]+"\t\t"+rowAverage(0)+"\n"+
				"2\t"+dataMax[1]+"\t\t"+rowAverage(1)+"\n"+
				"3\t"+dataMax[2]+"\t\t"+rowAverage(2)+"\n"+
				"4\t"+dataMax[3]+"\t\t"+rowAverage(3)+"\n"+
				"5\t"+dataMax[4]+"\t\t"+rowAverage(4)+"\n"+
				"6\t"+dataMax[5]+"\t\t"+rowAverage(5);
		
		return string;
	}
}
