import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) list.add(Integer.parseInt(br.readLine()));

        Map<Boolean, List<Integer>> collect = list.stream().collect(Collectors.partitioningBy(e -> e.intValue() > 0));
        List<Integer> zerobelow = collect.get(false).stream().sorted(Comparator.comparingInt(Integer::intValue)).collect(Collectors.toList());
        List<Integer> zeroupper = collect.get(true).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        int res = 0;
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < zerobelow.size(); i++) {
            if (zerobelow.get(i) < 0) {
                if (temp.isEmpty()) temp.add(zerobelow.get(i));
                else {
                    res += temp.get(0) * zerobelow.get(i);
                    temp.clear();
                }
            } else {
                if (!temp.isEmpty()) {
                    temp.clear();
                }
            }
        }

        if (!temp.isEmpty()) {
            res += temp.get(0);
            temp.clear();
        }

        for (int i = 0; i < zeroupper.size(); i++) {
            if (zeroupper.get(i) > 1) {
                if (temp.isEmpty()) temp.add(zeroupper.get(i));
                else {
                    res += temp.get(0) * zeroupper.get(i);
                    temp.clear();
                }
            } else {
                if (!temp.isEmpty()) {
                    res += temp.get(0);
                    temp.clear();
                }
                res += 1;
            }
        }

        if (!temp.isEmpty()) {
            res += temp.get(0);
            temp.clear();
        }

        System.out.println(res);
    }
}