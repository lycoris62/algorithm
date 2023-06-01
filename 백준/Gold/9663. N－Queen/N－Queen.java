import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, ans = 0;
    static int[] rows;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        rows = new int[N];

        dfs(0);
        System.out.println(ans);
    }

    static void dfs(int depth) {
        if (depth == N) {
            ans++;
            return;
        }

        for (int i = 0; i < N; i++) {
            rows[depth] = i;
            if (isPossible(depth)) {
                dfs(depth + 1);
            }
        }
    }

    static boolean isPossible(int depth) {
        for (int i = 0; i < depth; i++) {
            if (rows[i] == rows[depth]) {
                return false;
            } else if (Math.abs(i - depth) == Math.abs(rows[i] - rows[depth])) {
                return false;
            }
        }
        return true;
    }
}
