import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, S, min = Integer.MAX_VALUE;
    static int[] arr, sums;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        S = stoi(st.nextToken());

        arr = new int[N];
        sums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int input = stoi(st.nextToken());
            arr[i] = input;
            sums[i] = input;
        }

        for (int i = 1; i < N; i++) {
            sums[i] += sums[i - 1];
        }

        int end = 0;

        for (int start = 0; start < N; start++) {
            while (end < N && sums[end] - sums[start] + arr[start] < S) {
                end++;
            }

            if (end == N) {
                break;
            }

            int total = sums[end] - sums[start] + arr[start];

            if (total >= S) {
                min = Math.min(end - start + 1, min);
            }
        }

        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}
