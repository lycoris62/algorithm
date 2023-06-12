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
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());

        while (N-- > 0) {
            int x = stoi(br.readLine());
            for (int i = 0; i < x; i++) {
                sb.append("=");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
