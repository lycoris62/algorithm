import java.io.IOException;
import java.util.Scanner;

public class Main {

    static long N, pi;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = pi = sc.nextLong(); // 10^12

        for (long i = 2; i * i <= N; i++) {
            if (N % i == 0) {
                pi /= i;
                pi *= i - 1;
            }

            while (N % i == 0) {
                N /= i;
            }
        }

        if (N != 1) {
            pi /= N;
            pi *= N - 1;
        }

        System.out.println(pi);
    }
}
