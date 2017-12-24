import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
			System.out.println("Avg,Mode");
			int op = in.nextInt();
			int i;
			switch(op)
			{
				case 1:
					double mean = 0;
					System.out.println("Enter Col number");
					i = in.nextInt();
					for(String x: table.get(i))
						if(!x.equals(" "))
							mean += Double.parseDouble(x);
					mean /= table.get(i).size();
					for(int j = 0;j < N ; j++) 
						if(table.get(i).get(j).equals(" "))
							table.get(i).set(j, Double.toString(mean));
						
					break;

				case 2:
					int max = 0;
					String mode = "";
					HashMap<String,Integer> h = new HashMap<>();
					System.out.println("Enter Col number");
					i = in.nextInt();
					for(String x: table.get(i))
						if(!x.equals(" ")) {
							if(h.get(x) == null)
								h.put(x, 1);
							else
								h.put(x, h.get(x)+1);
							if(h.get(x) > max) {
								max = h.get(x);
								mode = x;
						}
					}
					
					for(int j = 0;j < N ; j++) 
						if(table.get(i).get(j).equals(" "))
							table.get(i).set(j, mode);
					break;
				default: 
					return;
					
		}
		
		}
	
		}
	}


