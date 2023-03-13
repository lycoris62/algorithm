package p25314;

import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        N = stoi(st.nextToken());
        for (int i = 0; i < N / 4; i++) sb.append("long ");
        sb.append("int");

        System.out.println(sb);
    }
}
