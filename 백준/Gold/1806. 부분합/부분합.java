import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, S, left = 0, right = 0, res = Integer.MAX_VALUE;
    static int[] arr, sums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        S = stoi(st.nextToken());
        arr = new int[N];
        sums = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = stoi(st.nextToken());
        }

        sums[0] = arr[0];
        for (int i = 1; i < N; i++) {
            sums[i] = sums[i - 1] + arr[i];
        }

        while (left <= right) {
            int sum = sums[right] - sums[left] + arr[left];

            if (sum >= S) {
                res = Math.min(res, right - left + 1);
                left++;
            } else {
                if (right == arr.length - 1) {
                    left++;
                } else {
                    right++;
                }
            }
        }

        System.out.println(res == Integer.MAX_VALUE ? 0 : res);
    }
}
