import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static long answer;
    static int[] machines;
    static long[] segments;
    static Map<Integer, Integer> map = new HashMap<>();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        machines = new int[N + 1];
        segments = new long[4 * N];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            machines[i] = stoi(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int aId = stoi(st.nextToken());
            map.put(aId, i);
        }

        for (int i = 1; i <= N; i++) {
            Integer bId = map.get(machines[i]);
            answer += sum(1, N, 1, bId + 1, N);
            update(1, N, 1, bId);
        }

        System.out.println(answer);
    }

    static void update(int start, int end, int now, int idx) {
        if (idx < start || end < idx) {
            return;
        }

        segments[now] += 1;

        if (start != end) {
            int mid = (start + end) / 2;
            update(start, mid, now * 2, idx);
            update(mid + 1, end, now * 2 + 1, idx);
        }
    }

    static long sum(int start, int end, int now, int left, int right) {
        if (right < start || end < left) {
            return 0;
        }

        if (left <= start && end <= right) {
            return segments[now];
        }

        int mid = (start + end) / 2;
        return sum(start, mid, now * 2, left, right) + sum(mid + 1, end, now * 2 + 1, left, right);
    }
}