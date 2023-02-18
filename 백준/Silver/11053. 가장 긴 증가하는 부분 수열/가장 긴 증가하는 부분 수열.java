import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static List<Integer> list;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        list = new ArrayList<>(N);
        dp = new int[N];
        
        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) list.add(stoi(st.nextToken()));

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (list.get(j) < list.get(i) && dp[i] < dp[j]) {
                    dp[i] = dp[j];
                }
            }
            dp[i] += 1; // 자기 자신
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
