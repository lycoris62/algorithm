import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] course;
    static long[] segment;
    static StringBuilder sb = new StringBuilder();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        course = new int[N];
        segment = new long[4 * N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            course[i] = stoi(st.nextToken());
        }

        init(1, 0, N - 1);

        for (int i = M - 1; i < N - M + 1; i++) {
            sb.append(find(1, 0, N - 1, i - M + 1, i + M - 1)).append(" ");
        }

        System.out.println(sb);
    }

    static long init(int node, int start, int end) {
        if (start == end) {
            return segment[node] = course[start];
        }

        int mid = (start + end) / 2;
        return segment[node] = Math.max(init(2 * node, start, mid), init(2 * node + 1, mid + 1, end));
    }

    static long find(int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return -1;
        }

        if (left <= start && end <= right) {
            return segment[node];
        }

        int mid = (start + end) / 2;
        return Math.max(find(2 * node, start, mid, left, right), find(2 * node + 1, mid + 1, end, left, right));
    }
}