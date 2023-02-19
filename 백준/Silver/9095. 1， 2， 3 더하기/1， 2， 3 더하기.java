import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        T = stoi(st.nextToken());
        while (T-- > 0) {
            N = stoi(br.readLine());
            System.out.println(dp(N));
        }
    }

    static int dp(int n) {
        if (n == 1) return 1;
        else if (n == 2) return 2;
        else if (n == 3) return 4;
        else return dp(n - 1) + dp(n - 2) + dp(n - 3);
    }
}