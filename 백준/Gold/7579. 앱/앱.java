import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int M;
    static List<int[]> apps;
    static int[][] dp;
    static int ans = Integer.MAX_VALUE;
    static int maxCost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        apps = new ArrayList<>();
        maxCost = 100 * N;
        dp = new int[N][maxCost + 1];
        
        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) apps.add(new int[]{stoi(st.nextToken()), 0});
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) apps.get(i)[1] = stoi(st.nextToken());

//        for (int[] app : apps) {
//            System.out.println(app[0] + ", " + app[1]);
//        }
        knapsack();
        System.out.println(ans);

//        for (int[] row : dp) {
//            for (Integer i : row) {
//                System.out.print(i + "\t");
//            }
//            System.out.println();
//        }
    }

    static void knapsack() {
        for (int appIndex = 0; appIndex < N; appIndex++) {

            int[] ints = apps.get(appIndex);
            int memory = ints[0];
            int cost = ints[1];

            for (int nowCost = 0; nowCost <= maxCost; nowCost++) {
                if (appIndex == 0) {
                    if (nowCost >= cost) dp[appIndex][nowCost] = memory;
                } else {
                    if (cost > nowCost) dp[appIndex][nowCost] = dp[appIndex - 1][nowCost];
                    else
                        dp[appIndex][nowCost] = Math.max(dp[appIndex - 1][nowCost], dp[appIndex - 1][nowCost - cost] + memory);
                }
                if (dp[appIndex][nowCost] >= M) ans = Math.min(ans, nowCost);
            }
        }
    }
}
