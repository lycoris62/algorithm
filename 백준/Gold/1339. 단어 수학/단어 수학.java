import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static int N, res, cost = 9;
    static String[] words;
    static int[] chars = new int[26];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        words = new String[N];
        IntStream.range(0, N).forEach(i -> words[i] = sc.next());

        for (String word : words) {
            int pow = (int) Math.pow(10, word.length() - 1);
            for (int i = 0; i < word.length(); i++) {
                chars[word.charAt(i) - 'A'] += pow;
                pow /= 10;
            }
        }

        Arrays.sort(chars);
        for (int i = chars.length - 1; i >= 0; i--) {
            res += chars[i] * cost--;
        }
        System.out.println(res);
    }
}
