import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static List<Integer> nums;
    static int[] ops;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        nums = new ArrayList<>(N);
        ops = new int[4];
        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) nums.add(stoi(st.nextToken()));
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) ops[i] = stoi(st.nextToken());

        dfs(1, nums.get(0), ops[0], ops[1], ops[2], ops[3]);

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int depth, int total, int plus, int minus, int multi, int divide) {
        if (depth == N) {
            max = Math.max(max, total);
            min = Math.min(min, total);
            return;
        }

        if (plus > 0) dfs(depth + 1, total + nums.get(depth), plus - 1, minus, multi, divide);
        if (minus > 0) dfs(depth + 1, total - nums.get(depth), plus, minus - 1, multi, divide);
        if (multi > 0) dfs(depth + 1, total * nums.get(depth), plus, minus, multi - 1, divide);
        if (divide > 0) dfs(depth + 1, total / nums.get(depth), plus, minus, multi, divide - 1);
    }
}
