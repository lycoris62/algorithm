import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Map<Character, Integer> map = new HashMap<>(Map.of(
            'A', 0,
            'B', 0)
    );

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        String votes = sc.next();

        for (int i = 0; i < V; i++) {
            char ch = votes.charAt(i);
            map.computeIfPresent(ch, (k, v) -> v + 1);
        }

        int voteA = map.get('A');
        int voteB = map.get('B');

        if (voteA == voteB) {
            System.out.println("Tie");
        } else {
            System.out.println(voteA > voteB ? "A" : "B");
        }
    }
}
