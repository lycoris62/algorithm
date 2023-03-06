import java.util.*;

public class Main {
    static long M = 1234567891L;
    static long R = 1L;
    static long H = 0L;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int L = sc.nextInt();
            String str = sc.next();

            for (int i = 0; i < L; i++) {
                H += (((int) str.charAt(i) - 96) * R) % M;
                R = (R * 31) % M;
            }

            System.out.println(H % M);
        }
    }
}
