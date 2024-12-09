import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 1_000_001;
    static int N, A, B, C;
    static int[] tree;
    static StringBuilder sb = new StringBuilder();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        tree = new int[4 * MAX];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A = stoi(st.nextToken());
            B = stoi(st.nextToken());

            if (A == 2) {
                C = stoi(st.nextToken());
                update(1, MAX, 1, B, C);
            } else {
                int candy = query(1, MAX, 1, B);
                sb.append(candy).append("\n");
            }
        }

        System.out.println(sb);
    }

    static int query(int start, int end, int idx, int target) {
        if (start == end) {
            update(1, MAX, 1, start, -1);
            return start;
        }

        int mid = (start + end) / 2;

        return target <= tree[idx * 2]
            ? query(start, mid, idx * 2, target)
            : query(mid + 1, end, idx * 2 + 1, target - tree[idx * 2]);
    }

    static void update(int start, int end, int idx, int target, int diff) {
        if (target < start || end < target) {
            return;
        }

        tree[idx] += diff;

        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;
        update(start, mid, idx * 2, target, diff);
        update(mid + 1, end, idx * 2 + 1, target, diff);
    }
}
