import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    static int N, M;
    static int[] arr, li;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];
        li = new int[N];

        IntStream.range(0, N).forEach(i -> li[i] = sc.nextInt());
        Arrays.sort(li);

        dfs(0, 0);

        System.out.println(sb);
    }

    static void dfs(int depth, int start) {
        if (depth == M) {
            for (int x : arr) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            arr[depth] = li[i];
            dfs(depth + 1, i);
        }
    }
}
