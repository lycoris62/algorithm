import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] marbles;
    static long ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        marbles = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            marbles[i] = stoi(st.nextToken());
        }

        Arrays.sort(marbles);
        for (int i = 0; i < N - 1; i++) {
            ans += marbles[i + 1] - marbles[i];
        }
        ans += marbles[N - 1] - marbles[0];

        System.out.println(ans);
    }
}
