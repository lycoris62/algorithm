import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final long OP = 1_000_000_007;
    static int N, K;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        long n = facto(N);
        long k = facto(K) * facto(N - K) % OP;

        System.out.println(n * pow(k, OP - 2) % OP);
    }

    static long facto(long num) {
        long x = 1L;

        while (num > 1) {
            x = (x * num) % OP;
            num--;
        }

        return x;
    }

    static long pow(long base, long exp) {
        if (exp == 1) {
            return base % OP;
        }

        long temp = pow(base, exp / 2);

        if (exp % 2 == 1) {
            return (temp * temp % OP) * base % OP;
        }

        return temp * temp % OP;
    }
}
