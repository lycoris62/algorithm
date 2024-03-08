import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, S, ans;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        S = stoi(st.nextToken());

        nums = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = stoi(st.nextToken());
        }

        bt(0, 0);

        System.out.println(S == 0 ? ans - 1 : ans);
    }

    static void bt(int depth, int total) {
        if (depth == N) {
            if (total == S) {
                ans++;
            }
            return;
        }

        bt(depth + 1, total);
        bt(depth + 1, total + nums[depth]);
    }
}
