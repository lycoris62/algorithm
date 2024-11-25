import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[][] maxArr;
    static int[][] minArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        maxArr = new int[2][3];
        minArr = new int[2][3];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int x0 = stoi(st.nextToken());
            int x1 = stoi(st.nextToken());
            int x2 = stoi(st.nextToken());

            maxArr[1][0] = Math.max(maxArr[0][0], maxArr[0][1]) + x0;
            maxArr[1][1] = Math.max(maxArr[0][0], Math.max(maxArr[0][1], maxArr[0][2])) + x1;
            maxArr[1][2] = Math.max(maxArr[0][1], maxArr[0][2]) + x2;

            maxArr[0][0] = maxArr[1][0];
            maxArr[0][1] = maxArr[1][1];
            maxArr[0][2] = maxArr[1][2];

            minArr[1][0] = Math.min(minArr[0][0], minArr[0][1]) + x0;
            minArr[1][1] = Math.min(minArr[0][0], Math.min(minArr[0][1], minArr[0][2])) + x1;
            minArr[1][2] = Math.min(minArr[0][1], minArr[0][2]) + x2;

            minArr[0][0] = minArr[1][0];
            minArr[0][1] = minArr[1][1];
            minArr[0][2] = minArr[1][2];
        }

        int max = Math.max(maxArr[0][0], Math.max(maxArr[0][1], maxArr[0][2]));
        int min = Math.min(minArr[0][0], Math.min(minArr[0][1], minArr[0][2]));

        System.out.println(max + " " + min);
    }
}