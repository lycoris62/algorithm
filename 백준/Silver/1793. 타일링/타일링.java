import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    static int N;
    static BigInteger[] memo = new BigInteger[251];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        memo[0] = BigInteger.ONE;
        memo[1] = BigInteger.ONE;
        memo[2] = BigInteger.valueOf(3);

        for (int i = 3; i < 251; i++) {
            memo[i] = memo[i - 1].add(memo[i - 2].multiply(BigInteger.TWO));
        }

        while (true) {
            String str = br.readLine();
            if (str == null) {
                break;
            }
            N = Integer.parseInt(str);
            System.out.println(memo[N]);
        }
    }
}
