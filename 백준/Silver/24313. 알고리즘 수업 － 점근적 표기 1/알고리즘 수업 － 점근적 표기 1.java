import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A1 = sc.nextInt();
        int A0 = sc.nextInt();
        int C = sc.nextInt();
        int N0 = sc.nextInt();

        boolean isCorrect = true;

        for (int n = N0; n <= 100; n++) {
            if (A1 * n + A0 > C * n) {
                isCorrect = false;
                break;
            }
        }

        System.out.println(isCorrect ? 1 : 0);
    }
}
