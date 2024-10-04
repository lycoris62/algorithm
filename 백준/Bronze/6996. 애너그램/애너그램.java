import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String first = st.nextToken();
            String second = st.nextToken();

            char[] firstArr = first.toCharArray();
            char[] secondArr = second.toCharArray();

            Arrays.sort(firstArr);
            Arrays.sort(secondArr);

            sb.append(first).append(" & ").append(second)
                .append(Arrays.equals(firstArr, secondArr) ? " are anagrams." : " are NOT anagrams.")
                .append("\n");
        }

        System.out.println(sb);
    }
}
