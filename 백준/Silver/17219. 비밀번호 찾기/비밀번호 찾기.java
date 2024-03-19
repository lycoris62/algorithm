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
        for (int i = 0; i < N; i++) {
            String[] tokens = br.readLine().split(" ");
            String site = tokens[0];
            String password = tokens[1];
            map.put(site, password);
        }

        for (int i = 0; i < M; i++) {
            String site = br.readLine();
            sb.append(map.get(site)).append("\n");
        }

        System.out.println(sb);
    }
}
