import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static String line;
    static BigInteger[] arr = new BigInteger[251];

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr[0] = arr[1] = BigInteger.ONE;
        arr[2] = BigInteger.valueOf(3);

        for (int i = 3; i < 251; i++) {
            arr[i] = arr[i - 1].add(arr[i - 2].multiply(BigInteger.TWO));
        }

        while ((line = br.readLine()) != null) {
            System.out.println(arr[stoi(line)]);
        }
    }
}