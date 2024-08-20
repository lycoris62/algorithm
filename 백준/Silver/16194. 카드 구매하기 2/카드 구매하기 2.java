import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int now = 1; now <= N; now++) {
            for (int i = 1; i <= now; i++) {
                arr[now] = Math.min(arr[now], arr[now - i] + arr[i]);
            }
        }

        System.out.println(arr[N]);
    }
}
