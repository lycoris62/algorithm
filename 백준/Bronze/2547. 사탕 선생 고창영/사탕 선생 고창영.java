import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            BigInteger sum = BigInteger.ZERO;
            
            for (int j = 0; j < n; j++) {
                sum = sum.add(scanner.nextBigInteger());
            }
            
            String reminder = String.valueOf(sum.remainder(BigInteger.valueOf(n)));
            System.out.println(reminder.equals("0") ? "YES" : "NO");
        }
    }
}