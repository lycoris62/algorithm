import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, K, idx;
    static List<Integer> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        sb.append("<");

        while (!q.isEmpty()) {
            idx = (idx + K - 1) % q.size();
            sb.append(q.remove(idx)).append(", ");
        }

        sb.delete(sb.lastIndexOf(","), sb.length());
        sb.append(">");

        System.out.println(sb);
    }
}
