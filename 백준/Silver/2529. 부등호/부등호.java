import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static char[] op;
    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        op = new char[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            op[i] = st.nextToken().charAt(0);
        }

        for (int i = 0; i < 10; i++) {
            int[] arr = new int[N + 1];
            arr[0] = i;
            boolean[] used = new boolean[10];
            used[i] = true;
            bt(1, arr, used);
        }

        String maxAns = String.format("%0" + (N + 1) + "d", max);
        String minAns = String.format("%0" + (N + 1) + "d", min);

        System.out.println(maxAns);
        System.out.println(minAns);
    }

    static void bt(int depth, int[] arr, boolean[] used) {
        if (depth >= N + 1) {
            long res = 0;
            for (int i = 0; i <= N; i++) {
                res = res * 10 + arr[i];
            }

            max = Math.max(max, res);
            min = Math.min(min, res);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (op[depth - 1] == '<') {
                if (arr[depth - 1] < i && !used[i]) {
                    arr[depth] = i;
                    used[i] = true;
                    bt(depth + 1, arr, used);
                    used[i] = false;
                }
            } else {
                if (arr[depth - 1] > i && !used[i]) {
                    arr[depth] = i;
                    used[i] = true;
                    bt(depth + 1, arr, used);
                    used[i] = false;
                }
            }
        }
    }
}
