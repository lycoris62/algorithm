import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int score = 0;
        int temp = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] == 0) {
                temp = 0;
                continue;
            }

            temp++;
            score += temp;
        }

        System.out.println(score);
    }
}
