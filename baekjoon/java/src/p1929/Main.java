package p1929;

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

        printPrime(M);
    }

    static void printPrime(int n) {
        int[] prime = new int[n + 1];
        prime[0] = prime[1] = 0;

        for (int i = 2; i <= n; i++) prime[i] = i;

        for (int i = 2; i <= n; i++) {
            if (prime[i] == 0) continue;
            for (int j = i * 2; j <= n; j += i) prime[j] = 0;
        }

        for (int i : prime) if (i >= N && i != 0) System.out.println(i);
    }
}
