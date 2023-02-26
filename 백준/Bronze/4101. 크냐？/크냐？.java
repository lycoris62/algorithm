import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            N = stoi(st.nextToken());
            M = stoi(st.nextToken());

            if (N == 0 && M == 0) break;
            System.out.println(N > M ? "Yes" : "No");
        }
    }
}
