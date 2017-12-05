import java.util.Scanner;


public class Demo8 {
	
	static Scanner in = new Scanner(System.in);


	public static void main(String[] args) {

		System.out.println("Enter N");
		int N = in.nextInt();

		float X[] = new float[N];
		float Y[] = new float[N];
		float _x=0,_y=0,Sxy=0,Sxx=0;

		System.out.println("X \t Y");
		for (int i = 0; i < N; i++) {
			X[i] = in.nextFloat();
			Y[i] = in.nextFloat();
			_x += X[i] / N;
			_y += Y[i] / N;
		}
		
		for (int i = 0; i < N; i++) {
			Sxy += (X[i] - _x)*(Y[i] - _y);
			Sxx += (X[i] - _x)*(X[i] - _x);
		}
		
		System.out.println("Enter an X value");
		float x = in.nextFloat();
		System.out.println("Corresponding Y = " + (_y + (Sxy/Sxx)*(x-_x) ) );

	}

}
