package CHAC.A;

import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        map = new HashMap<>();
        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            int x = stoi(st.nextToken());
            if (x == 1) map.put(1, map.getOrDefault(1, 0) + 1);
            else if (x == 0) map.put(0, map.getOrDefault(0, 0) + 1);
            else map.put(-1, map.getOrDefault(-1, 0) + 1);
        }

        int invalidLimit = N % 2 == 0 ? N / 2 : N / 2 + 1;
        if (map.getOrDefault(0, 0) >= invalidLimit) System.out.println("INVALID");
        else System.out.println(map.getOrDefault(-1, 0) >= map.getOrDefault(1, 0) ? "REJECTED" : "APPROVED");
    }
}
