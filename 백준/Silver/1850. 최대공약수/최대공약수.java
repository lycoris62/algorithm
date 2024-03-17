import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();

        int gcd = gcd(Math.max(a, b), Math.min(a, b));
        System.out.println("1".repeat(gcd));
    }

    static int gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }

        return (int) a;
    }
}
