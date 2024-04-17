import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T, N;
    static char[] arr;
    static char[] ops = {' ', '+', '-'};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = stoi(st.nextToken());

        while (T-- > 0) {
            N = stoi(br.readLine());

            arr = new char[N - 1];
            dfs(0);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int depth) {
        if (depth == N - 1) {

            StringBuilder temp = new StringBuilder();
            for (int i = 1; i < N; i++) {
                temp.append(i).append(arr[i - 1]);
            }
            temp.append(N);

            String rawExp = temp.toString();
            String exp = rawExp.replace(" ", "");

            String[] nums = exp.split("[+-]");
            String[] operators = Arrays.stream(exp.split("[0-9]"))
                .filter(s -> !s.isBlank())
                .toArray(String[]::new);

            int sum = stoi(nums[0]);

            for (int i = 1; i < nums.length; i++) {
                sum += operators[i - 1].equals("+") ? stoi(nums[i]) : -stoi(nums[i]);
            }

            if (sum == 0) {
                sb.append(rawExp).append("\n");
            }

            return;
        }

        for (int i = 0; i < 3; i++) {
            arr[depth] = ops[i];
            dfs(depth + 1);
        }
    }
}
