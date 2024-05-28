import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (sc.nextInt() == 1) {
                count++;
            }
        }

        System.out.println(count > N / 2 ? "Junhee is cute!" : "Junhee is not cute!");
    }
}
