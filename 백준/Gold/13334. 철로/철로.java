import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, D;
    static int answer;
    static List<Road> roads = new ArrayList<>();
    static Queue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int h = stoi(st.nextToken());
            int o = stoi(st.nextToken());

            roads.add(new Road(Math.min(h, o), Math.max(h, o)));
        }

        D = stoi(br.readLine());

        sweeping();

        System.out.println(answer);
    }

    private static void sweeping() {
        
        Collections.sort(roads);

        for (Road road : roads) {
            if (road.end - road.start > D) {
                continue;
            }

            pq.add(road.start);

            while (!pq.isEmpty() && pq.peek() + D < road.end) {
                pq.poll();
            }

            answer = Math.max(answer, pq.size());
        }
    }

    static class Road implements Comparable<Road> {
        int start, end;

        public Road(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Road other) {
            if (this.end == other.end) {
                return Integer.compare(this.start, other.start);
            }

            return Integer.compare(this.end, other.end);
        }
    }
}
