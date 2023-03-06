import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T;
    static int N;
    static PriorityQueue<Long> pq;
    static long res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        T = stoi(st.nextToken());
        for (int i = 0; i < T; i++) {
            N = stoi(br.readLine());
            pq = new PriorityQueue<>();
            res = 0L;

            st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) pq.add(Long.parseLong(st.nextToken()));

            while (pq.size() >= 2) {
                long first = pq.poll();
                long second = pq.poll();
                long sum = first + second;
                res += sum;
                pq.add(sum);
            }
            System.out.println(res);
        }
    }
}