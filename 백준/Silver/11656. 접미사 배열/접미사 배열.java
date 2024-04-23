import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        StringBuilder sb = new StringBuilder();

        String[] suffixes = new String[word.length()];

        for (int i = 0; i < word.length(); i++) {
            suffixes[i] = word.substring(i);
        }

        Arrays.sort(suffixes);

        for (String suffix : suffixes) {
            sb.append(suffix).append("\n");
        }

        System.out.println(sb);
    }
}
