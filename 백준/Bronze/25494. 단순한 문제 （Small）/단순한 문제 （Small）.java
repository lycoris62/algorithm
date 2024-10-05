import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T, count;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = stoi(st.nextToken());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            int c = stoi(st.nextToken());

            count = 0;

            for (int i = 1; i <= a; i++) {
                for (int j = 1; j <= b; j++) {
                    for (int k = 1; k <= c; k++) {
                        if (i % j == j % k && j % k == k % i && i % j == k % i) {
                            count++;
                        }
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
