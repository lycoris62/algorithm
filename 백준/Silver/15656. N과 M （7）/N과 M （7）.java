import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int[] li;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];
        li = new int[N];

        for (int i = 0; i < N; i++) {
            li[i] = sc.nextInt();
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
            arr[depth] = li[i];
            dfs(depth + 1);
        }
    }
}
