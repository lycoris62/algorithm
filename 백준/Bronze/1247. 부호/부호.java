import java.io.*;
import java.math.BigInteger;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static BigInteger ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            N = stoi(br.readLine());
            ans = BigInteger.ZERO;

            for (int j = 0; j < N; j++) {
                ans = ans.add(BigInteger.valueOf(Long.parseLong(br.readLine())));
            }

            int S = ans.compareTo(BigInteger.ZERO);

            if (S == 0) System.out.println(0);
            else if (S > 0) System.out.println("+");
            else System.out.println("-");
        }
    }
}
