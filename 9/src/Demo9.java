import java.util.Random;
import java.util.Scanner;


public class Demo9 {
	
	static Scanner in = new Scanner(System.in);
	static int N;
	static int K;
	static double X[] ;
	static double Y[];
	static int cluster[];
	static double meanX[] ;
	static double meanY[];
	
	static double euclidean(int i, int j) {
		return Math.sqrt((X[i] - meanX[j])*(X[i] - meanX[j]) + (Y[i] - meanY[j])*(Y[i] - meanY[j]));
	}

	static int assign(int i) {
		double k = 99999;
		int min_index = 0;
		for (int j = 0; j < K; j++) 
			if(euclidean(i,j) < k ) {
					k = euclidean(i,j);
					min_index = j;
			}
		return min_index;	
	}
	static void nullify() {
		for (int i = 0; i < K; i++) {
			meanX[i] = 0;
			meanY[i] = 0;
		}
	}

	public static void main(String[] args) {
		
		Random r = new Random();

		System.out.println("Enter N");
		N = in.nextInt();
		System.out.println("Enter K");
		K = in.nextInt();
		
		X = new double[N] ;
		Y = new double[N];
		cluster = new int[N];
		meanX = new double[K];
		meanY = new double[K];
		

		System.out.println("Random X \t Y");
		for (int i = 0; i < N; i++) {
			X[i] = r.nextInt();
			Y[i] = r.nextInt();
		}
		
		for (int i = 0; i < K; i++) {
			int p = r.nextInt(N);
			meanX[i] = X[p];
			meanY[i] = Y[p];
		}
		
		for (int k = 0; k < 500; k++) {
				for (int i = 0; i < N; i++) 
					cluster[i] = assign(i);	
				nullify();
				for (int i = 0; i < N; i++) { 
					meanX[cluster[i]] +=  X[i]/N;
					meanY[cluster[i]] +=  Y[i]/N;
				}
		}
		for (int i = 0; i < N; i++) 
			System.out.println("("+X[i]+","+Y[i]+")" + "  -> " + cluster[i]);	
		for (int i = 0; i < K; i++) 
			System.out.println("Mean ("+meanX[i]+","+meanY[i]+")" + "  of " + i);	
		

	}

}
