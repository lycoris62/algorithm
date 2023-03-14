import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M, maxNum;
    static int[] snacks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = stoi(st.nextToken());
        N = stoi(st.nextToken());
        snacks = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) snacks[i] = stoi(st.nextToken());

        maxNum = Arrays.stream(snacks).max().getAsInt();

        System.out.println(bisect());
    }

    static int bisect() {
        int min = 0;
        int max = Arrays.stream(snacks).max().getAsInt() + 1;

        Arrays.sort(snacks);

        while (min < max) {
            int mid = (min + max) / 2;
            if (mid == 0 || mid > maxNum) {
                System.out.println(0);
                System.exit(0);
            }

            int cnt = 0;
            for (int i = 0; i < N; i++)
                cnt += (snacks[i] / mid);

            if (cnt < M) max = mid;
            else min = mid + 1;
        }

        return max - 1;
    }
}
