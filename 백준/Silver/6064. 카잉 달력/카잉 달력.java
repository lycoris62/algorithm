import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T, M, N, X, Y;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = stoi(st.nextToken());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            M = stoi(st.nextToken());
            N = stoi(st.nextToken());
            X = stoi(st.nextToken()) - 1;
            Y = stoi(st.nextToken()) - 1;

            int answer = -1;

            for (int i = X; i < N * M; i += M) {
                if (i % N == Y) {
                    answer = i + 1;
                    break;
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
