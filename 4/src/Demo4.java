import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;


public class Demo4 {
	
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		System.out.println("Enter N and m");
		int N = in.nextInt();
		int m = in.nextInt();

		int table[][] = new int[N][m];

		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("data.dat")));
			for (int i = 0; i < N; i++) {
				String[] singleLine = br.readLine().split("\t");
				for(int j=0; j< singleLine.length; j++) 
					table[i][j] = Integer.parseInt(singleLine[j]);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int classCol = m - 1;
		for(int j = 0; j<classCol; j++)
		{
			double c0 = 0, c1 = 0;
			for (int i = 0; i < N; i++) 
				if(table[i][j] == 0)
					if(table[i][classCol] == 0)
						c0++;
					else
						c1++;	
			
			double zeroes = c0 + c1;
			double gini0 = 1 - (c0*c0 + c1*c1)/(zeroes*zeroes);

			c0 = 0;
			c1 = 0;
			
			for (int i = 0; i < N; i++) 
				if(table[i][j] == 1)
					if(table[i][classCol] == 0)
						c0++;
					else
						c1++;
			double ones = c0 + c1;			
			double gini1 = 1 - (c0*c0 + c1*c1)/(ones*ones);		
			
			double giniP = 1 - (zeroes*zeroes + ones*ones)/(N*N);
			double gain = giniP -(zeroes*gini0 + ones*gini1)/N;
			
			System.out.println("\nCol " + j+ ": Gain: " + gain);	
			System.out.println("Ginis: C0=" + gini0  + " C1=" + gini1 + " Parent=" + giniP);	
				
		}


	}
}
