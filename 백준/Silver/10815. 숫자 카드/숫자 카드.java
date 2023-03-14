import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        N = stoi(st.nextToken());
        cards = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) cards[i] = stoi(st.nextToken());

        Arrays.sort(cards);

        M = stoi(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < M; i++) sb.append(bisec(stoi(st.nextToken())) + " ");
        System.out.println(sb);
    }

    static int bisec(int n) {
        int min = 0;
        int max = N - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            int m = cards[mid];

            if (m < n) min = mid + 1;
            else if (m > n) max = mid - 1;
            else return 1;
        }
        return 0;
    }
}
