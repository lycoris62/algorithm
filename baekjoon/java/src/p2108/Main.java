package p2108;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static List<Integer> li;
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        li = new ArrayList<>();
        map = new HashMap<>();
        int maxCount = 0;

        while (N-->0) {
            int x = stoi(new StringTokenizer(br.readLine(), " ").nextToken());
            li.add(x);
            int v = map.getOrDefault(x, 0) + 1;
            map.put(x, v);
            if (maxCount < v) maxCount = v;
        }

        int finalMaxCount = maxCount;
        List<Integer> collect = map.entrySet().stream().filter(x -> x.getValue() == finalMaxCount).map(Map.Entry::getKey).collect(Collectors.toList());
        Collections.sort(collect);
        maxCount = collect.size() > 1 ? collect.get(1) : collect.get(0);

        Collections.sort(li);
        int median = li.get(li.size() / 2);
        int max = li.stream().max(Integer::compareTo).get();
        int min = li.stream().min(Integer::compareTo).get();

        System.out.println(Math.round(li.stream().collect(Collectors.averagingInt(Integer::intValue))));
        System.out.println(median);
        System.out.println(maxCount);
        System.out.println(max - min);
    }
}
