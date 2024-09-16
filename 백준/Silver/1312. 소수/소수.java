import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int A, B, N, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = stoi(st.nextToken());
        B = stoi(st.nextToken());
        N = stoi(st.nextToken());

        answer = A % B;

        for (int i = 0; i < N - 1; i++) {
            answer *= 10;
            answer %= B;
        }

        answer *= 10;
        answer /= B;

        System.out.println(answer);
    }
}
