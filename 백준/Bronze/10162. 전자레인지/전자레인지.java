import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int five = N / 300;
        N %= 300;
        int one = N / 60;
        N %= 60;
        int ten = N / 10;
        N %= 10;

        if (N > 0) {
            System.out.println(-1);
        } else {
            System.out.println(five + " " + one + " " + ten);
        }
    }
}
