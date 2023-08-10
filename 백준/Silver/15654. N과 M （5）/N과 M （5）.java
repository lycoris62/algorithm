import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int[] li;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        arr = new int[M];
        li = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            li[i] = scanner.nextInt();
        }

        Arrays.sort(li);
        dfs(0);

        System.out.println(sb);
    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int x : arr) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            arr[depth] = li[i];
            dfs(depth + 1);
            visited[i] = false;
        }
    }
}
