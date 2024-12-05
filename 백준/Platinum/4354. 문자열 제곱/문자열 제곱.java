import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String text;
    static int[] table;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (!(text = br.readLine()).equals(".")) {
            makeTable();
            sb.append(kmp()).append("\n");
        }

        System.out.println(sb);
    }

    static int kmp() {
        String parent = text.repeat(2);

        int count = 0;
        int idx = 0;

        for (int i = 1; i < parent.length(); i++) {
            while (idx > 0 && (parent.charAt(i) != text.charAt(idx))) {
                idx = table[idx - 1];
            }

            if (parent.charAt(i) == text.charAt(idx)) {
                if (idx == text.length() - 1) {
                    count++;
                    idx = table[idx];
                } else {
                    idx++;
                }
            }
        }

        return count;
    }

    static void makeTable() {
        table = new int[text.length()];
        int idx = 0;

        for (int i = 1; i < text.length(); i++) {
            while (idx > 0 && (text.charAt(i) != text.charAt(idx))) {
                idx = table[idx - 1];
            }

            if (text.charAt(i) == text.charAt(idx)) {
                table[i] = ++idx;
            }
        }
    }
}
