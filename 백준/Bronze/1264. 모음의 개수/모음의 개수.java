import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');

        while (true) {
            String str = br.readLine().toLowerCase();
            if (str.equals("#")) {
                break;
            }
            int res = 0;
            for (int i = 0; i < str.length(); i++) {
                if (set.contains(str.charAt(i))) res++;
            }
            bw.write(res + "\n");
        }
        bw.close();
    }
}