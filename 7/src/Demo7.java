import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class Demo7 {
	
	static Scanner in = new Scanner(System.in);
	
	static double product(double a[], int b[])
	{
		double p = 0;
		int i;
		for (i = 0; i < a.length - 1; i++) 
			p += a[i]*b[i];
		p += a[i] * 1;
		return p;
	}

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
				
		int test[] = new int[m-1];	
		double W[] = new double[m];	
		
		System.out.println("Enter test record");	
		for (int i = 0; i < m-1; i++) 
			test[i] = in.nextInt();
		//System.out.println("Enter random weights");	
		for (int i = 0; i < m; i++) 
			W[i] = -1.23456;
				
		for (int k = 0; k < 500; k++) 		
			for (int i = 0; i < N; i++)
			{
				double _y = product(W, table[i]);
				for (int j = 0; j < m-1; j++)
					W[j] = W[j] + 0.01*(table[i][m-1] - _y)*table[i][j];
				W[m-1] = W[m-1] + 0.01*(table[i][m-1] - _y)*1;
			}
		
		System.out.println("Test belongs to class " + (product(W, test) > 0? 1: -1) );
		System.out.println("W " + Arrays.toString(W));



	}
}
