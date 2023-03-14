import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, res, std = 1_000_000_000, x, y;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        nums = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++)
            nums[i] = stoi(st.nextToken());

        std = -nums[0];
        for (int i = 0; i < N; i++) nums[i] += std;

        int start = 0;
        int end = N - 1;
        res = Integer.MAX_VALUE;

        while (start < end) {
            int startValue = nums[start];
            int endValue = nums[end];
            int sumValue = startValue + endValue;

            int abs = Math.abs(sumValue - 2 * std);

            if (abs < res) {
                res = abs;
                x = startValue - std;
                y = endValue - std;
            } else if (sumValue > 2 * std) {
                end--;
            } else {
                start++;
            }
        }
        System.out.println(x +" " + y);
    }
}
