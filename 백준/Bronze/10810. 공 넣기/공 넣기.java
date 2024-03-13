import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[] buckets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        buckets = new int[N + 1];

        while (M --> 0) {
            st = new StringTokenizer(br.readLine());
            int i = stoi(st.nextToken());
            int j = stoi(st.nextToken());
            int k = stoi(st.nextToken());

            for (int idx = i; idx <= j; idx++) {
                buckets[idx] = k;
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(buckets[i] + " ");
        }
    }
}
