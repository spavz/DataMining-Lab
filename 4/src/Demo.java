import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Demo {
	
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.out.println("Enter N");
		int N = in.nextInt();
		System.out.println("Enter no col");
		int nCol = in.nextInt();
		
		ArrayList<ArrayList<Integer>> table = new ArrayList<>();
		for(int i = 0; i < nCol; i++) 
			table.add(new ArrayList<Integer>());
		

		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("data.dat")));
			String line;
			while ((line = br.readLine()) !=null) {
				String[] singleLine = line.split("\t");
				for(int i=0; i< singleLine.length; i++) 
					table.get(i).add(Integer.parseInt(singleLine[i]));
			}
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		int classCol = table.size()-1;
		for(int i=0; i < classCol; i++)
		{
			double c0=0,c1=0;
			double zeroes = Collections.frequency(table.get(i), 0);
			double ones = Collections.frequency(table.get(i), 1);

			for(int j=0; j < N; j++) 
				if(table.get(i).get(j) == 0 && table.get(classCol).get(j) == 0)
					c0++;
			c1 = zeroes - c0;
			double gini0 = 1 - (c0*c0/(zeroes*zeroes)) - (c1*c1/(zeroes*zeroes));

			c0 = 0;
			c1 = 0;
			
			for(int j=0; j < N; j++) 
				if(table.get(i).get(j) == 1 && table.get(classCol).get(j) == 0)
					c0++;
			c1 = ones - c0;
			double gini1 = 1 - (c0*c0/(ones*ones)) - (c1*c1/(ones*ones));
			
			System.out.println("Gain: " + (zeroes*gini0 + ones*gini1)/N);	
			System.out.println("Ginis: " + gini0  + " " + gini1);	
				
		}
	
	}

}
