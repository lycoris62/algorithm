import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(gcd(Math.max(a, b), Math.min(a, b)));
        System.out.println(lcm(Math.max(a, b), Math.min(a, b)));
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
