import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M, answer;
    static int[] six, one;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        six = new int[M];
        one = new int[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            six[i] = stoi(st.nextToken());
            one[i] = stoi(st.nextToken());
        }

        int x = N / 6;
        int y = N % 6;

        int sixMin = Arrays.stream(six).min().getAsInt();
        int oneMin = Arrays.stream(one).min().getAsInt();

        answer = x * Math.min(sixMin, oneMin * 6);

        if (y != 0) {
            answer += Math.min(sixMin, oneMin * y);
        }

        System.out.println(answer);
    }
}
