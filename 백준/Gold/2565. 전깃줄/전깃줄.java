import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] dp;
    static List<Line> lines = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            lines.add(new Line(a, b));
        }

        Collections.sort(lines);

        int max = getMaxInDP();

        System.out.println(N - max);
    }

    private static int getMaxInDP() {
        for (int now = 0; now < N; now++) {
            dp[now] = 1; // 최소 개수

            for (int prev = 0; prev < now; prev++) {
                if (lines.get(now).b > lines.get(prev).b) {
                    dp[now] = Math.max(dp[now], dp[prev] + 1);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}

class Line implements Comparable<Line> {

    int a, b;

    public Line(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Line o) {
        return Integer.compare(this.a, o.a);
    }
}
