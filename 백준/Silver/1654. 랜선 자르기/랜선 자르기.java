import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int K, N;
    static int[] lines;
    static long start = 1L, end = Integer.MAX_VALUE;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = stoi(st.nextToken());
        N = stoi(st.nextToken());

        lines = new int[K];

        for (int i = 0; i < K; i++) {
            lines[i] = stoi(br.readLine());
        }

        while (start < end) {
            long mid = (start + end + 1) / 2;

            int count = getCount(mid);

            if (count >= N) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start);
    }

    private static int getCount(long mid) {
        int count = 0;
        for (int line : lines) {
            count += (int) (line / mid);
        }
        return count;
    }
}
