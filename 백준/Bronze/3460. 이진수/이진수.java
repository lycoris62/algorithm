import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int T;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        T = stoi(st.nextToken());
        for (int i = 0; i < T; i++) {
            N = stoi(br.readLine());
            String s = Integer.toBinaryString(N);
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(s.length() - j - 1) == '1') System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
