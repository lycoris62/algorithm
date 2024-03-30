import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        ans = new int[N + M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ans[i] = stoi(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = N; i < N + M; i++) {
            ans[i] = stoi(st.nextToken());
        }

        Arrays.sort(ans);

        for (int x : ans) {
            sb.append(x).append(" ");
        }

        System.out.println(sb);
    }
}
