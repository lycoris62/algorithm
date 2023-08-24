import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static int N, res;
    static Queue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        IntStream.range(0, N).forEach(i -> pq.add(sc.nextInt()));

        while (pq.size() != 1) {
            int first = pq.poll();
            int second = pq.poll();

            int sum = first + second;
            res += sum;
            pq.add(sum);
        }

        System.out.println(res);
    }
}
