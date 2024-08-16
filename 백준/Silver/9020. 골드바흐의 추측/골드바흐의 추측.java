import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T, N;
    static final int MAX = 100_000_000;
    static List<Integer> primes = new ArrayList<>();
    static boolean[] isPrime = new boolean[MAX + 1];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = stoi(st.nextToken());

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(MAX); i++) {
            if (isPrime[i]) {
                primes.add(i);
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        while (T-- > 0) {
            N = stoi(br.readLine());

            for (int i = N / 2; i >= 2; i--) {
                if (isPrime[i] && isPrime[N - i]) {
                    sb.append(i).append(" ").append(N - i).append("\n");
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}
