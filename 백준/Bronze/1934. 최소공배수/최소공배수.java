import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = stoi(st.nextToken());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());

            sb.append(lcm(a, b)).append("\n");
        }

        System.out.println(sb);
    }

    static int lcm(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);

        while (min != 0) {
            int temp = min;
            min = max % min;
            max = temp;
        }

        return a * b / max;
    }
}
