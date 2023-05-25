import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, W, L, weight = 0, time = 0;
    static Queue<Integer> trucks = new LinkedList<>(), bridge = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        W = stoi(st.nextToken());
        L = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            trucks.add(stoi(st.nextToken()));
        }

        for (int i = 0; i < W; i++) {
            bridge.add(0);
        }

        while (!bridge.isEmpty()) {
            weight -= bridge.poll();
            time++;
            if (!trucks.isEmpty()) {
                if (trucks.peek() + weight <= L) {
                    weight += trucks.peek();
                    bridge.add(trucks.poll());
                } else {
                    bridge.add(0);
                }
            }
        }

        System.out.println(time);
    }
}
