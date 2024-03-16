import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, K;
    static int[] kettles;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        kettles = new int[N];

        for (int i = 0; i < N; i++) {
            kettles[i] = stoi(br.readLine());
        }

        System.out.println(parametricSearch());
    }

    private static long parametricSearch() {
        long left = 1;
        long right = Arrays.stream(kettles).max().getAsInt();

        while (left <= right) {
            long mid = (left + right) / 2;

            int cnt = 0;
            for (int kettle : kettles) {
                cnt += kettle / mid;
            }

            if (cnt < K) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }
}
