import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, K;
    static long answer;
    static int[] bags;
    static Queue<Jewel> jewels = new PriorityQueue<>();
    static Queue<Integer> pricePQ = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        bags = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = stoi(st.nextToken());
            int price = stoi(st.nextToken());

            jewels.add(new Jewel(weight, price));
        }

        for (int i = 0; i < K; i++) {
            bags[i] = stoi(br.readLine());
        }

        Arrays.sort(bags);

        for (int maxBagWeight : bags) {

            while (!jewels.isEmpty() && jewels.peek().weight <= maxBagWeight) {
                pricePQ.add(jewels.poll().price);
            }

            if (!pricePQ.isEmpty()) {
                answer += pricePQ.poll();
            }
        }

        System.out.println(answer);
    }

    static class Jewel implements Comparable<Jewel> {
        int weight, price;

        public Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        public int compareTo(Jewel o) {
            if (this.weight != o.weight) {
                return Integer.compare(this.weight, o.weight);
            }

            return Integer.compare(o.price, this.price);
        }
    }
}
