package p11651;

import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static List<int[]> li;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        li = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            li.add(new int[]{stoi(st.nextToken()), stoi(st.nextToken())});
        }

        Collections.sort(li, (int[] a, int[] b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            else return a[1] - b[1];
        });

        for (int[] ints : li) System.out.println(ints[0] + " " + ints[1]);
    }
}
