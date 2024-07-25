import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static long total;
    static int start = Integer.MIN_VALUE;
    static int end = Integer.MIN_VALUE;
    static List<Line> lines = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = stoi(st.nextToken());
            int end = stoi(st.nextToken());

            lines.add(new Line(start, end));
        }

        Collections.sort(lines);

        for (Line line : lines) {
            if ((start <= line.start && line.start <= end) && (start <= line.end && line.end <= end)) {
                continue;
            }

            if ((start <= line.start && line.start <= end) && line.end > end) {
                end = line.end;
                continue;
            }

            if (line.start > end) {
                total += end - start;
                start = line.start;
                end = line.end;
            }
        }

        total += end - start;

        System.out.println(total);
    }

    static class Line implements Comparable<Line> {
        int start, end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Line o) {
            if (this.start == o.start) {
                return Integer.compare(this.end, o.end);
            }

            return Integer.compare(this.start, o.start);
        }
    }
}
