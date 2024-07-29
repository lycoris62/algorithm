import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, answer, vote;
    static Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        vote = stoi(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            pq.add(stoi(br.readLine()));
        }

        while (!pq.isEmpty() && vote <= pq.peek()) {
            int top = pq.poll();

            top--;
            answer++;
            vote++;

            pq.add(top);
        }

        System.out.println(answer);
    }
}
