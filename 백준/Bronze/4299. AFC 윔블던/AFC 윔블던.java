import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        if ((N + M) % 2 == 1 || N < M) {
            System.out.println(-1);
            return;
        }

        int hi = (N + M) / 2;
        int lo = (N - M) / 2;
        System.out.println(hi + " " + lo);
    }
}
