import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static int N, M;
    static int[] arr, li;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];
        li = new int[N];
        visited = new boolean[N];

        IntStream.range(0, N).forEach(i -> li[i] = sc.nextInt());
        Arrays.sort(li);

        dfs(0, 0);
        System.out.println(sb);
    }

    static void dfs(int depth, int start) {
        if (depth == M) {
            Arrays.stream(arr).forEach(x -> sb.append(x).append(" "));
            sb.append("\n");
            return;
        }

        int before = -1;
        for (int i = start; i < N; i++) {
            if (visited[i] || before == li[i]) continue;

            before = li[i];
            visited[i] = true;
            arr[depth] = li[i];
            dfs(depth + 1, i);
            visited[i] = false;
        }
    }
}
