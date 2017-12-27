import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;


public class DemoModified {
	
	static Scanner in = new Scanner(System.in);


	public static void main(String[] args) throws NumberFormatException, IOException {

		System.out.println("Enter N and m");
		int N = in.nextInt();
		int m = in.nextInt();

		int table[][] = new int[N][m];

		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("data.dat")));
			for (int i = 0; i < N; i++) {
				String[] singleLine = br.readLine().split(",");
				for(int j=0; j< singleLine.length; j++) 
					table[i][j] = Integer.parseInt(singleLine[j]);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(true) {
			for(int i=0; i< N; i++) {
				for(int j=0; j< m; j++) 
					System.out.print(table[i][j] + "\t");	
				System.out.println();	
			}
			
			System.out.println("Agg,Dicrete,Start Sample");
			int op = in.nextInt();
			System.out.println("Enter Col number");
			int j = in.nextInt();
			
			if(op == 1) {
				double mean = 0;
				for (int i = 0; i < N; i++) 
					mean += table[i][j];
				mean /= N;
				System.out.println("Mean: " + mean);
			}
					
			else if(op == 2) 
				for(int i = 0; i < N ; i++) 
					table[i][j] /= 10;
			
			else if(op == 3) {
				HashSet<Integer> h = new HashSet<>();			
				for(int i = 0; i < N ; i++) {
					if(h.contains(table[i][j]))
						continue;
					h.add(table[i][j]);
					for(int k=0; k< m; k++) 
						System.out.print(table[i][k] + "\t");	
					System.out.println();	
				}
				System.out.println("\n\n");	
			}
		}
	}
}
