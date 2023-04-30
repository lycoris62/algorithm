import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            map.put(i, 0);
        }

        for (int i = 0; i < str.length(); i++) {
            int key = str.charAt(i) - 'a';
            map.put(key, map.get(key) + 1);
        }

        for (int x : map.values()) {
            System.out.printf("%d ", x);
        }
    }
}
