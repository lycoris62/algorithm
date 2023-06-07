import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        while (N --> 0) {
            if (check(br.readLine()))
                res++;
        }

        System.out.println(res);
    }

    static boolean check(String str) {
        List<Character> list = new ArrayList<>();
        list.add(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                list.add(str.charAt(i));
            }
        }

        Set<Character> set = new HashSet<>(list);
        return list.size() == set.size();
    }
}
