import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T, N;
    static Map<String, Integer> map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = stoi(st.nextToken());

        while (T-- > 0) {
            N = stoi(br.readLine());
            map = new HashMap<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                map.put(st.nextToken(), stoi(st.nextToken()));
            }

            String top = map.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get().getKey();
            sb.append(top).append("\n");
        }

        System.out.println(sb);
    }
}
