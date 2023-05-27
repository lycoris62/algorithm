import java.io.*;
import java.util.*;

public class Main {
    static long res = 0;
    static String pw;
    static Map<Character, Integer> chars = new HashMap<>();
    static final int MOD = 900528;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        for (int i = 1; i <= str.length(); i++) {
            chars.put(str.charAt(i - 1), i);
        }

        pw = br.readLine();

        for (int i = 0; i < pw.length(); i++) {
            res *= chars.size();
            res += chars.get(pw.charAt(i));
            res %= MOD;
        }

        System.out.println(res);
    }
}
