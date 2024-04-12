import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] nums;
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        nums = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = stoi(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            dfs(i, 0, 0);
        }

        int[] arr = set.stream().mapToInt(Integer::intValue).sorted().toArray();
        int prev = 0;
        for (int x : arr) {
            if (x - prev >= 2) {
                break;
            }
            prev = x;
        }

        System.out.println(prev + 1);
    }

    static void dfs(int depth, int start, int total) {
        if (depth == N) {
            set.add(total);
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                dfs(depth + 1, i + 1, total + nums[i]);
                visited[i] = false;
            }
        }
    }
}
