
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            dfs(1, list);
        }

        System.out.println(sb);
    }

    static void dfs(int depth, List<Integer> list) {
        if (depth == M) {
            for (int x : list) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (list.contains(i)) {
                continue;
            }
            List<Integer> li = new ArrayList<>(list);
            li.add(i);
            dfs(depth + 1, li);
        }
    }
}
