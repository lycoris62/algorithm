import java.io.*;
import java.util.*;

public class Main {

    static int N, max;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        for (int i = 0; i < N; i++) {
            int money;
            st = new StringTokenizer(br.readLine());

            int A = stoi(st.nextToken());
            int B = stoi(st.nextToken());
            int C = stoi(st.nextToken());

            if (A == B && B == C) {
                money = 10000 + (A * 1000);
            } else if (A != B && B != C && A != C) {
                money = Math.max(A, Math.max(B, C)) * 100;
            } else {
                money = 1000 + 100 * (A == B || A == C ? A : B);
            }

            max = Math.max(max, money);
        }

        System.out.println(max);
    }
}
