import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        while (N-- > 0) {
            int x = stoi(br.readLine());
            if (x != 0) {
                pq.add(x);
                continue;
            }
            sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
        }

        System.out.println(sb);
    }
}
