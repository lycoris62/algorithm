import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine();

        Set<String> set = new HashSet<>();

        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j <= word.length() - i; j++) {
                String substring = word.substring(j, j + i);
                set.add(substring);
            }
        }

        System.out.println(set.size());
    }
}
