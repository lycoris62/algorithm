import java.util.*;

public class Main {

    static int maxLength = 0;
    static List<List<Character>> words = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            String word = sc.next();
            maxLength = Math.max(maxLength, word.length());

            words.add(new ArrayList<>());

            for (char ch : word.toCharArray()) {
                words.get(i).add(ch);
            }
        }

        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < 5; j++) {
                List<Character> word = words.get(j);

                if (word.size() <= i) {
                    continue;
                }
                sb.append(word.get(i));
            }
        }

        System.out.println(sb);
    }
}
