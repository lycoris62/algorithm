import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static Map<String, String> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        for (int i = 1; i <= N; i++) {
            String x = br.readLine();
            map.put(x, String.valueOf(i));
            map.put(String.valueOf(i), x);
        }

        for (int i = 0; i < M; i++) {
            String question = br.readLine();
            sb.append(map.get(question)).append("\n");
        }

        System.out.println(sb);
    }
}
