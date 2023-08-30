import java.util.Scanner;

public class Main {

    static long N, K;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        long start = 1;
        long end = K;

        while (start < end) {
            long mid = (start + end) / 2;

            long res = countBelow(mid);

            if (res >= K) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(end);
    }

    static long countBelow(long target) {
        long cnt = 0;
        for (int i = 1; i <= N; i++) {
            cnt += Math.min(N, target / i);
        }
        return cnt;
    }
}
