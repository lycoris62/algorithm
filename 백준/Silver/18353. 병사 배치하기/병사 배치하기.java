import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        arr = new int[N];
        dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = stoi(st.nextToken());
        }

        // 최장 길이 부분 수열 LIS -> DP!! (DP에 이분탐색까지 쓰는 건 플레..)
        // DP만 쓰면 O(N^2)
        // N <= 2천 -> 400만.

        // 하 LIS 맨날 까먹어 이 빡 대가리야 !!!!!!

        // 왼쪽에서 내림차순 -> 오른쪽에서 오름차순!! 반대로 풀자.

        for (int i = N - 1; i >= 0; i--) {
            dp[i] = 1; // 부분 수열의 최소 길이는 1 (자기자신)

            // 왼쪽부터 돌면서, 자기자신보다 작은 값이 dp값이 크거나 같으면 max + 1
            for (int j = N - 1; j > i; j--) {
                if (arr[i] > arr[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        System.out.println(N - Arrays.stream(dp).max().getAsInt());
    }
}
