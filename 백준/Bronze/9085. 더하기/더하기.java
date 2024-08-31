import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T, N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = stoi(st.nextToken());

        while (T-- > 0) {
            N = stoi(br.readLine());
            st = new StringTokenizer(br.readLine());

            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += stoi(st.nextToken());
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}
