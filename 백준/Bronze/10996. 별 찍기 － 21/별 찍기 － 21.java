import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        for (int i = 0; i < 2 * N; i++) {
            if (i % 2 == 0) {
                sb.append("* ".repeat((N + 1) / 2)).append("\n");
            } else {
                sb.append(" *".repeat(N / 2)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
