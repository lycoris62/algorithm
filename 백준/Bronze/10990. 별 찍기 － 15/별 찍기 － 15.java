import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = n - 1; j > i; j--) {
				System.out.print(" ");
			}
            
			System.out.print("*");
            
			for (int j = 0; j < 2 * i - 1; j++) {
				System.out.print(" ");
			}
            
			if (i > 0) {
				System.out.print("*");
            }

			System.out.println("");
		}
	}
}