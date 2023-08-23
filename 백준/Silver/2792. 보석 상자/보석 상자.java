import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    static int N, M;
    static int[] nums;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        nums = new int[M];
        IntStream.range(0, M).forEach(i -> nums[i] = sc.nextInt());

        int start = 1;
        int end = Arrays.stream(nums).max().getAsInt();

        while (start < end) {
            int mid = (start + end) / 2;

            int res = 0;
            for (int i = 0; i < M; i++) {
                res += nums[i] / mid;
                if (nums[i] % mid != 0) res++;
            }

            if (res <= N) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(end);
    }
}
