import java.util.Scanner;


public class Demo10 {
	
	static Scanner in = new Scanner(System.in);


	public static void main(String[] args) {

		System.out.println("Enter confusion matrix");
		
		System.out.println("True Positives");
		float TP = in.nextInt();
		System.out.println("False Positives)");
		float FP = in.nextInt();
		System.out.println("False Negatives");
		float FN = in.nextInt();
		System.out.println("True Negatives");
		float TN = in.nextInt();

		System.out.println("Sensitivity / recall: " + TP/(TP + FN));
		System.out.println("Specificity: " + TN/(TN + FP));
		System.out.println("Precision: " + TP/(TP + FP));
		System.out.println("Accuracy: " + (TP + TN)/(TP + FP + FN + TN));


	}

}
