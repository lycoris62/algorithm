import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T, K;
    static TreeMap<Integer, Integer> map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = stoi(st.nextToken());

        while (T-- > 0) {
            K = stoi(br.readLine());
            map = new TreeMap<>();

            while (K-- > 0) {
                st = new StringTokenizer(br.readLine());

                String op = st.nextToken();
                int n = stoi(st.nextToken());

                if (op.equals("I")) {
                    map.put(n, map.getOrDefault(n, 0) + 1);
                    continue;
                }

                if (map.isEmpty()) {
                    continue;
                }

                int num = n == 1 ? map.lastKey() : map.firstKey();

                int value = map.put(num, map.get(num) - 1);
                if (value == 1) {
                    map.remove(num);
                }
            }

            if (map.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }

        System.out.println(sb);
    }
}
