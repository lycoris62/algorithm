import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int K, N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        K = stoi(st.nextToken());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        System.out.println(Math.max(K * N - M, 0));
    }
}
