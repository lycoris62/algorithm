import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] ones = new int[41];

        ones[5] = 5;
        ones[6] = 8;

        for (int i = 7; i <= 40; i++) {
            ones[i] = ones[i - 1] + ones[i - 2];
        }

        System.out.println(ones[N] + " " + (N - 2));
    }
}
