import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        r = stoi(st.nextToken());
        c = stoi(st.nextToken());
        int length = (int) Math.pow(2, N);
        System.out.println(dfs(r, c, 0, length));
    }

    static int dfs(int n, int m, int firstValue, int len) {
        if (len == 2)
            return firstValue + (2 * n + m);

        len /= 2;
        firstValue += (len * len) * ((n >= len ? 1 : 0) * 2 + (m >= len ? 1 : 0));
        n %= len;
        m %= len;
        return dfs(n, m, firstValue, len);
    }
}
