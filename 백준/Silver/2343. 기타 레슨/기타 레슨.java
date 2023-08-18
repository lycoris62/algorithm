import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    static int N, M;
    static int[] times;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        times = new int[N];
        IntStream.range(0, N).forEach(i -> times[i] = sc.nextInt());

        int start = Arrays.stream(times).max().getAsInt();
        int end = Arrays.stream(times).sum();

        while (start < end) {
            int mid = (start + end) / 2;
            int total = 1, temp = 0;
            for (int time : times) {
                temp += time;
                if (temp > mid) {
                    total++;
                    temp = time;
                }
            }

            if (total <= M) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(end);
    }
}
