import java.util.*;

public class Main {
    static int M = 1234567891;
    static int R = 31;
    static int H = 0;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int L = sc.nextInt();
            int[] intArray = Arrays.stream(sc.next().split(""))
                    .mapToInt((String s) -> (int)s.charAt(0) - 96)
                    .toArray();

            for (int i = 0; i < L; i++) {
                H += ( (Math.pow(R, i) % M)  * intArray[i]) % M;
            }

            System.out.println(H % M);
        }
    }
}
