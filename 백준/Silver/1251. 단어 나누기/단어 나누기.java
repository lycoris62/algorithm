import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static Set<String> words = new HashSet<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        for (int i = 0; i < word.length() - 2; i++) {
            for (int j = i + 1; j < word.length() - 1; j++) {
                for (int k = j + 1; k < word.length(); k++) {

                    String first = word.substring(0, j);
                    String second = word.substring(j, k);
                    String third = word.substring(k);

                    String reversedWord = new StringBuilder(first).reverse()
                            .append(new StringBuilder(second).reverse())
                            .append(new StringBuilder(third).reverse())
                            .toString();

                    words.add(reversedWord);
                }
            }
        }

        List<String> wordList = words.stream().sorted().collect(Collectors.toList());

        System.out.println(wordList.get(0));
    }
}
