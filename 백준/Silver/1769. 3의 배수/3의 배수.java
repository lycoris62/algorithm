import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String X;
    static int count = 0;

    static long stol(String s) {
        return Long.parseLong(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        X = br.readLine();

        while (X.length() != 1) {
            long sum = 0;
            for (int i = 0; i < X.length(); i++) {
                sum += stol(String.valueOf(X.charAt(i)));
            }
            count++;
            X = String.valueOf(sum);
        }

        System.out.println(count);
        System.out.println(stol((X)) % 3 == 0 ? "YES" : "NO");
    }
}
