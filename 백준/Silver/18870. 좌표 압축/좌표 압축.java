import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static List<Integer> li = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        N = stoi(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) li.add(stoi(st.nextToken()));

        List<Integer> collect = li.stream().distinct().sorted().collect(Collectors.toList());

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < collect.size(); i++) map.put(collect.get(i), i);

        for (int i = 0; i < N; i++) sb.append(map.get(li.get(i)) + " ");
        System.out.println(sb);
    }
}
