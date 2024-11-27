import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static String text, pattern;
    static int[] table;
    static List<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        text = sc.nextLine();
        pattern = sc.nextLine();

        table = new int[pattern.length()];

        kmp();

        sb.append(list.size()).append("\n");
        for (Integer x : list) {
            sb.append(x).append(" ");
        }

        System.out.println(sb);
    }

    static void makeTable() {
        int idx = 0;

        for (int i = 1; i < pattern.length(); i++) {
            while (idx > 0 && (pattern.charAt(i) != pattern.charAt(idx))) {
                idx = table[idx - 1];
            }

            if (pattern.charAt(i) == pattern.charAt(idx)) {
                idx++;
                table[i] = idx;
            }
        }
    }

    static void kmp() {
        makeTable();
        int idx = 0;

        for (int i = 0; i < text.length(); i++) {
            while (idx > 0 && (text.charAt(i) != pattern.charAt(idx))) {
                idx = table[idx - 1];
            }

            if (text.charAt(i) == pattern.charAt(idx)) {
                if (idx == pattern.length() - 1) {
                    list.add(i - idx + 1);
                    idx = table[idx];
                } else {
                    idx++;
                }
            }
        }
    }
}
