import java.util.Scanner;

public class Main {

    static String parent, pattern;
    static int[] table;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        parent = sc.next();
        pattern = sc.next();

        table = new int[pattern.length()];

        System.out.println(kmp());
    }

    static void makeTable() {
        int idx = 0;

        for (int i = 1; i < pattern.length(); i++) {
            // 연속해서 동일한 접두사 및 접미사가 있었다가 더 이상 일치하지 않는 경우 이전 동일 개수로 회귀
            while (idx > 0 && (pattern.charAt(i) != pattern.charAt(idx))) {
                idx = table[idx - 1];
            }

            // 접두사와 접미사가 같으면 idx 1씩 증가
            if (pattern.charAt(i) == pattern.charAt(idx)) {
                idx++;
                table[i] = idx;
            }
        }
    }

    static int kmp() {
        makeTable();
        int idx = 0;

        for (int i = 0; i < parent.length(); i++) {
            while (idx > 0 && (parent.charAt(i) != pattern.charAt(idx))) {
                idx = table[idx - 1];
            }
            
            if (parent.charAt(i) == pattern.charAt(idx)) {
                if (idx == pattern.length() - 1) {
                    return 1;
                }
                idx++;
            }
        }

        return 0;
    }
}
