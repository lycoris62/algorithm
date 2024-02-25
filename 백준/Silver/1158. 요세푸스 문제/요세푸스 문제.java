import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, K, temp = 1;
    static Queue<Integer> q = new ArrayDeque<>();
    static List<Integer> ans = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        while (!q.isEmpty()) {
            if (temp == K) {
                ans.add(q.poll());
                temp = 1;
                continue;
            }

            q.add(q.poll());
            temp++;
        }

        sb.append("<");
        for (Integer i : ans) {
            sb.append(i).append(", ");
        }
        sb.delete(sb.lastIndexOf(","), sb.length());
        sb.append(">");

        System.out.println(sb);
    }
}
