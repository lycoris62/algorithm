import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < 8; i++) {
            map.put(i + 1, sc.nextInt());
        }

        List<Entry<Integer, Integer>> list = map.entrySet()
            .stream()
            .sorted(Comparator.comparingInt(entry -> -entry.getValue()))
            .limit(5)
            .sorted(Comparator.comparingInt(Entry::getKey))
            .collect(Collectors.toList());

        int total = list.stream().mapToInt(Entry::getValue).sum();
        System.out.println(total);

        for (Entry<Integer, Integer> entry : list) {
            System.out.print(entry.getKey() + " ");
        }
    }
}
