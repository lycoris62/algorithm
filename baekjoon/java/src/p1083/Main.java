package p1083;

import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static List<Integer> li;
    static int S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        li = new ArrayList<>(N);
        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) li.add(stoi(st.nextToken()));
        S = stoi(br.readLine());

        int moveCnt = 0;
        int changeIdx = 0;

        while (moveCnt < S && changeIdx < N - 1) {
            int maxNum = li.get(changeIdx);
            int maxIdx = -1;

            int idx = changeIdx + 1;
            int count = 1;

            while (moveCnt + count <= S && idx < N) {
                int num = li.get(idx);
                if (num > maxNum) {
                    maxNum = num;
                    maxIdx = idx;
                }
                count++;
                idx++;
            }

            if (maxIdx != -1) {
                li.remove(maxIdx);
                li.add(changeIdx, maxNum);
                moveCnt += maxIdx - changeIdx;
            }
            changeIdx++;
        }

        StringBuilder sb = new StringBuilder();
        for (int x : li) sb.append(x).append(" ");
        System.out.println(sb);
    }
}

/*
7
10 20 30 40 50 60 70
1

 */