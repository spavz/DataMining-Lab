import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class Demo3 {
	
	static Scanner in = new Scanner(System.in);
	
	static String expand(int x) {
		int a = 0x100;
		String itemSet = "";
		while(a>0) {
			if((a & x) > 0)
				itemSet += a + " ";
			a >>= 1;
		}
		return itemSet;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		System.out.println("Enter no of tids");
		int N = in.nextInt();
		System.out.println("Enter no of unique items ");
		int d = in.nextInt();
		System.out.println("Enter support");
		float sup = in.nextFloat();
		System.out.println("Enter conf");
		float conf = in.nextFloat();


		int table[] = new int[N];

		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("data.dat")));
			for (int i = 0; i < N; i++) {
				String[] singleLine = br.readLine().split("\t");
				for(int j=0; j< singleLine.length; j++) 
					table[i] |= Integer.parseInt(singleLine[j]);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int power =  (int) Math.pow(2, d);
		HashMap<Integer, Float> h = new HashMap<>();
		
		for (int i = 1; i < power; i++) {
			float sigma = 0;
			for (int j = 0; j < N; j++) 
				if((i & table[j]) == i)
					sigma++;			
			if(sigma/N >= sup)
				h.put(i, sigma/N);		
		}
		
		System.out.println("Freq itemsets");
		for (int key : h.keySet()) 
		    System.out.println(expand(key) + "\t\tsup=" + h.get(key));
				
		System.out.println("\nStrong rules");
		int all = power - 1;		
		for (int i = 1; i < all; i++) 	
			if(h.get(all) / h.get(i) >= conf) 
				System.out.println(expand(i) + " -> " + expand(all - i) + "\tconf=" + h.get(all) / h.get(i));	
		
	}
}
