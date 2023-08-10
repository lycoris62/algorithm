import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    static int N, M;
    static int[] arr, li;
    static boolean[] visited;
    static Set<String> set = new LinkedHashSet<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];
        li = new int[N];
        visited = new boolean[N];

        IntStream.range(0, N).forEach(i -> li[i] = sc.nextInt());
        Arrays.sort(li);

        dfs(0);
        set.forEach(System.out::println);
    }

    static void dfs(int depth) {
        if (depth == M) {
            String str = Arrays.stream(arr).mapToObj(x -> x + " ").collect(Collectors.joining()).trim();
            set.add(str);
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
