import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Demo6 {
	
	static Scanner in = new Scanner(System.in);
	
	static double euclidean(int x, int y, int X, int Y) {
		return Math.sqrt((x - X)*(x - X) + (y - Y)*(y - Y));
	}

	public static void main(String[] args) {
		
		Random r = new Random();

		System.out.println("Enter N");
		int N = in.nextInt();
		System.out.println("Enter K");
		int K = in.nextInt();
		System.out.println("Enter test record");	
		int x = in.nextInt();
		int y = in.nextInt();
		
		
		ArrayList<Pair> a = new ArrayList<>();	 
		for (int i = 0; i < N; i++) {
			int X = r.nextInt(100);
			int Y = r.nextInt(100);
			a.add(new Pair(euclidean(x,y,X,Y), r.nextInt(2)));
		}
	
		a.sort((o1, o2) -> o1.get().compareTo(o2.get()));
		int c = 0;
		for (int i = 0; i < K; i++) 
			c += a.get(i).getclass();
		
		if(c > (K-c))
			System.out.println("Class 1");	
		else
			System.out.println("Class 0");	

		System.out.println(a);	

		

		
	}

}
