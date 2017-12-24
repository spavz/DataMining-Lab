import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Demo {
	
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.out.println("Enter N");
		int N = in.nextInt();
		System.out.println("Enter no col");
		int nCol = in.nextInt();
		
		ArrayList<ArrayList<String>> table = new ArrayList<>();
		for(int i = 0; i < nCol; i++) 
			table.add(new ArrayList<String>());
		

		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("data.dat")));
			String line;
			while ((line = br.readLine()) !=null) {
				String[] singleLine = line.split(",");

				for(int i=0; i< singleLine.length; i++) 
					table.get(i).add(singleLine[i]);
			
			}
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(true) {
			
			for(int i=0; i< N; i++) {
				for(int j=0; j< nCol; j++) 
					System.out.print(table.get(j).get(i) + "\t");	
				System.out.println();	
			}
			System.out.println("Agg,Dicrete,Start Sample");
			int op = in.nextInt();
			int i;
			
			switch(op)
			{
				case 1:
					double mean = 0;
					System.out.println("Enter Col number");
					i = in.nextInt();
					
					for(String x: table.get(i))
						mean += Double.parseDouble(x);
					mean /= table.get(i).size();
					System.out.println("Mean: " + mean);
					break;

				case 2:		
					System.out.println("Enter Col number");
					i = in.nextInt();
					
					for(int j = 0;j < N ; j++) {
						int x = Integer.parseInt(table.get(i).get(j));
						x -= (x%10);
						table.get(i).set(j,x + " - " + (x+9));
					}
					break;
					
				case 3:		
					System.out.println("Enter Col number");
					i = in.nextInt();
					System.out.println("Sample:");
					HashSet<String> h = new HashSet<>();

					h.add(table.get(i).get(0));
					for (int j = 0; j < nCol; j++) 
						System.out.print( table.get(j).get(0) + " ");
					System.out.println();
					
					for (int j = 1; j < N; j++) {
						if(h.contains(table.get(i).get(j)))
							continue;
						h.add(table.get(i).get(j));
						for (int j2 = 0; j2 < nCol; j2++) 		
							System.out.print( table.get(j2).get(j) + "\t");
						
						System.out.println();
					}
					System.out.println("\n");
	
					break;
				default: 
					return;
					
		}
		
		}
	
		}
	}


