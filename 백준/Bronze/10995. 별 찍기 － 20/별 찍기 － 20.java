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

        for (int i = 0; i < N; i++) {
            if (i % 2 == 1) {
                sb.append(" ");
            }

            for (int j = 0; j < N; j++) {
                sb.append("*").append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
