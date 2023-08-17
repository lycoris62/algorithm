import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        trees = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) trees[i] = stoi(st.nextToken());
        int end = Arrays.stream(trees).max().getAsInt();
        int start = 0;

        while (start < end) {
            int mid = (start + end) / 2;
            long sum = getSum(mid);
            if (sum >= M) {
                start = mid + 1;
            } else {
                end = mid;
            }
            if (sum < M) end = mid;
            else start = mid + 1;
        }
        System.out.println(start - 1);
    }

    static long getSum(int h) {
        long sum = 0;
        for (int i = 0; i < trees.length; i++) {
            sum += Math.max(trees[i] - h, 0);
        }
        return sum;
    }
}
