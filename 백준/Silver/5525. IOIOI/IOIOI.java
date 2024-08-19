import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, S, answer;
    static String word;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        S = stoi(br.readLine());
        word = br.readLine();

        int count = 0;

        for (int i = 0; i < S; i++) {
            char ch = word.charAt(i);

            if ((ch == 'O') || (i + 2 >= S) || (!word.startsWith("OI", i + 1))) {
                if (count != 0) {
                    list.add(count);
                    count = 0;
                }
                continue;
            }

            count++;
            i += 1;
        }

        if (count != 0) {
            list.add(count);
        }

        for (Integer i : list) {
            if (N > i) {
                continue;
            }

            answer += i - N + 1;
        }

        System.out.println(answer);
    }
}
