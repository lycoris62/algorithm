import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static Map<String, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        map = new HashMap<>(N);

        for (int i = 0; i < N; i++) {
            String key = br.readLine();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int max = map.values().stream().max(Integer::compareTo).get();

        List<String> collect = map.entrySet().stream().filter(e -> e.getValue() == max).map(Map.Entry::getKey).sorted().collect(Collectors.toList());
        System.out.println(collect.get(0));
    }
}
