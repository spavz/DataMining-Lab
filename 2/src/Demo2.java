import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;


public class Demo2 {
	
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		System.out.println("Enter N and m");
		int N = in.nextInt();
		int m = in.nextInt();

		String table[][] = new String[N][m];

		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("data.dat")));
			for (int i = 0; i < N; i++) {
				String[] line = br.readLine().split(",");
				for(int j=0; j< line.length; j++) 
					table[i][j] = line[j];
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
			
			System.out.println("Avg,Mode");
			int op = in.nextInt();
			System.out.println("Enter Col number");
			int j = in.nextInt();
			
			if(op == 1) {
				double mean = 0;
				try {
					for (int i = 0; i < N; i++) 
						if(!table[i][j].equals("na"))
							mean += Integer.parseInt(table[i][j]);
					mean /= N;
					for (int i = 0; i < N; i++) 
						if(table[i][j].equals("na"))
							table[i][j] = Double.toString(mean);				
				} catch (NumberFormatException e) {
					System.out.println("Error: Non numeric column");
				}				
			}				
			else if(op == 2){
				ArrayList<String> a = new ArrayList<>();
				for (int i = 0; i < N; i++) 
					if(!table[i][j].equals("na"))
						a.add(table[i][j]);			
				String mode = a.get(0);
				int count = 0;
				for(String x: a)
					if(Collections.frequency(a, x) > count) {
						count = Collections.frequency(a, x);
						mode = x;
					}
				for (int i = 0; i < N; i++) 
					if(table[i][j].equals("na"))
						table[i][j] = mode;	
				
			}			
		}
		
		

	}
}
