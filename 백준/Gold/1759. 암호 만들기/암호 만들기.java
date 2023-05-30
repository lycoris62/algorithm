import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int L, C;
    static char[] chars;
    static char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    static Set<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        L = stoi(st.nextToken());
        C = stoi(st.nextToken());
        chars = new char[C];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < C; i++) {
            chars[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(chars);

        for (int i = 0; i < C - L + 1; i++) {
            dfs(0, new char[L], 0, i);
        }

        List<String> collect = set.stream().sorted().collect(Collectors.toList());
        for (String s : collect) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int depth, char[] str, int vowelCnt, int start) {
        if (depth == L) {
            if (vowelCnt >= 1 && str.length - vowelCnt >= 2) {
                set.add(String.valueOf(str));
            }
            return;
        }

        for (int i = start; i < C; i++) {
            str[depth] = chars[i];
            boolean isVowel = false;
            for (char vowel : vowels) {
                if (vowel == chars[i]) {
                    isVowel = true;
                }
            }
            dfs(depth + 1, str, isVowel ? vowelCnt + 1 : vowelCnt, i + 1);
        }
    }
}
