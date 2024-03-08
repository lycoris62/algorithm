import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, S, ans;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        S = stoi(st.nextToken());

        nums = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = stoi(st.nextToken());
        }

        Arrays.sort(nums);

        bt(0, 0, 0);

        System.out.println(ans);
    }

    static void bt(int depth, int start, int total) {
        if (total == S && depth > 0) { // 합이 S가 되는 부분순열.
            ans++;
        }
        if (depth == N) { // 끝까지 배열을 돌아도 S보다 작음
            return;
        }

        for (int i = start; i < N; i++) { // 순서가 없는 조합
            bt(depth + 1, i + 1, total + nums[i]);
        }
    }
}
