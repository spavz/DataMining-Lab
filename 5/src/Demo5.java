import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;


public class Demo5 {
	
	static Scanner in = new Scanner(System.in);
	
	static double product(double a[])
	{
		double p = 1;
		for (int i = 0; i < a.length; i++) 
			p *= a[i];
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
		
		System.out.println("Enter test record");	
		
		int test[] = new int[m];	
		double class0[] = new double[m];
		double class1[] = new double[m];
		
		for (int i = 0; i < m-1; i++) 
			test[i] = in.nextInt();


		for (int i = 0; i < N; i++) 
			if(table[i][m-1] == 0)
				class0[m-1] ++;
			else
				class1[m-1] ++;
				
		
		for (int i = 0; i < N; i++) 
			for (int j = 0; j < m-1; j++) 
				if (test[j] == table[i][j]) 
					if(table[i][m-1] == 0) 
						class0[j] += 1/class0[m-1];
					else 
						class1[j] += 1/class1[m-1];
				
		class0[m-1] /= N;
		class1[m-1] /= N;
	
		
		if (product(class0) > product(class1))
			System.out.println("Test belongs to class 0");
		else
			System.out.println("Test belongs to class 1");	


	}
}
