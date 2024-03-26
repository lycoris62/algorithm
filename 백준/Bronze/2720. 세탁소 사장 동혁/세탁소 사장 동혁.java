import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T;
    static int[] coins = {25, 10, 5, 1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = stoi(st.nextToken());
        
        while (T-- > 0) {
            int x = stoi(br.readLine());
            for (int i = 0; i < 4; i++) {
                int a = x / coins[i];
                x = x % coins[i];
                sb.append(a).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}
