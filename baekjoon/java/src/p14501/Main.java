package p14501;

import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, max;
    static int[] terms, prices;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        terms = new int[N];
        prices = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            terms[i] = stoi(st.nextToken());
            prices[i] = stoi(st.nextToken());
        }

        dfs(0, 0);

        System.out.println(max);
    }

    static void dfs(int day, int total) {
        if (day == N) {
            max = Math.max(max, total);
            return;
        }

        if (day + terms[day] <= N) {
            dfs(day + terms[day], total + prices[day]);
        }
        dfs(day + 1, total);
    }
}

