
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static int N;
    static int[] arr, heights;
    static boolean[] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        arr = new int[N];
        heights = new int[N];
        visited = new boolean[N];

        IntStream.range(0, N).forEach(i -> heights[i] = sc.nextInt());
        dfs(0);
    }

    static void dfs(int depth) {
        if (depth == N) {
            for (int i = 1; i <= N; i++) {
                int cnt = 0;
                for (int j = 0; j < N; j++) {
                    if (i == arr[j]) break;
                    if (arr[j] > i) cnt++;
                }
                if (heights[i - 1] != cnt) return;
            }
            
            Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
            System.exit(0);
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            arr[depth] = i + 1;
            dfs(depth + 1);
            visited[i] = false;
        }
    }
}
