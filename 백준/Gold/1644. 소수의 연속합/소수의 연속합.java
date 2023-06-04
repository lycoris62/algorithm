import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, res = 0;
    static boolean[] notPrime;
    static int[] sums;
    static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        if (N == 1) {
            System.out.println(0);
            return;
        }

        notPrime = new boolean[N + 1];
        setPrime();

        for (int i = 0; i <= N; i++) {
            if (!notPrime[i])
                primes.add(i);
        }

        sums = new int[primes.size()];
        sums[0] = primes.get(0);
        for (int i = 1; i < primes.size(); i++) {
            sums[i] = sums[i - 1] + primes.get(i);
        }

        int left = 0, right = 0;
        while (left <= right && right < primes.size()) {
            int value = sums[right] - sums[left] + primes.get(left);
            if (value > N) {
                left++;
            } else if (value < N) {
                right++;
            } else {
                res++;
                right++;
            }
        }

        System.out.println(res);
    }

    static void setPrime() {
        notPrime[0] = notPrime[1] = true;
        for (int i = 2; i * i <= N; i++) {
            if (!notPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    notPrime[j] = true;
                }
            }
        }
    }
}
