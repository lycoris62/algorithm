import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a1 = sc.nextInt();
        int b1 = sc.nextInt();
        int a2 = sc.nextInt();
        int b2 = sc.nextInt();

        int c = a1 * b2 + a2 * b1;
        int d = b1 * b2;

        int x = gcd(c, d);

        System.out.println((c / x) + " " + (d / x));
    }

    static int gcd(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);

        while (min != 0) {
            int temp = min;
            min = max % min;
            max = temp;
        }

        return max;
    }
}
