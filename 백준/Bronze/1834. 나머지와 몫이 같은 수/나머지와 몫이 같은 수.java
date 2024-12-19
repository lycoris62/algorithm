import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		long sum = 0;

		for (int i = 0; i < N; i++) {
			sum += (N + 1) * i;
		}
        
		System.out.println(sum);
	}
}