import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> cards = new PriorityQueue<>(N);
        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) cards.add(Long.parseLong(st.nextToken()));

        for (int i = 0; i < M; i++) {
            long a = cards.poll();
            long b = cards.poll();
            cards.add(a + b);
            cards.add(a + b);
        }

        System.out.println(cards.stream().collect(Collectors.summingLong(Long::longValue)));
    }
}
