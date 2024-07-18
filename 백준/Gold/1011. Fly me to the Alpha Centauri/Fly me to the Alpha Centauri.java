import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T, X, Y;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = stoi(st.nextToken());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            X = stoi(st.nextToken());
            Y = stoi(st.nextToken());

            int distance = Y - X;
            int max = (int) Math.sqrt(distance);

            if (max == Math.sqrt(distance)) {
                sb.append(2 * max - 1);
            } else if (distance <= max * max + max) {
                sb.append(2 * max);
            } else {
                sb.append(2 * max + 1);
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
