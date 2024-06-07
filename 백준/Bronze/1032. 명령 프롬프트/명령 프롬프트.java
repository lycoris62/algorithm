import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, length;
    static char[] answer;
    static List<String> strList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        for (int i = 0; i < N; i++) {
            strList.add(br.readLine());
        }

        length = strList.get(0).length();

        answer = new char[length];

        for (int i = 0; i < length; i++) {
            Set<Character> set = new HashSet<>();

            for (String str : strList) {
                set.add(str.charAt(i));
            }

            answer[i] = set.size() >= 2 ? '?' : (char) set.toArray()[0];
        }

        System.out.println(answer);
    }
}
