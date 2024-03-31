import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = stoi(st.nextToken());
        B = stoi(st.nextToken());

        System.out.println(lcm(A, B));
    }

    static long lcm(long a, long b) {
        long max = Math.max(a, b);
        long min = Math.min(a, b);

        while (min != 0) {
            long temp = min;
            min = max % min;
            max = temp;
        }

        return a * b / max;
    }
}
