package p13305;

import java.io.*;
import java.util.*;

public class Main {
    static long stoi(String s) {
        return Long.parseLong(s);
    }

    static long N, cost = 0;
    static long[] lens, costs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        lens = new long[(int) (N - 1)];
        costs = new long[(int) N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N - 1; i++) lens[i] = stoi(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) costs[i] = stoi(st.nextToken());

        long min = costs[0];

        for (int i = 0; i < lens.length; i++) {
            if (costs[i] < min)
                min = costs[i];
            cost += min * lens[i];
        }

        System.out.println(cost);
    }
}

