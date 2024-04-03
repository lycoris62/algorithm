import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while (true) {
            if (isPalindrome(n) && isPrimeNumber(n)) {
                System.out.println(n);
                return;
            }
            n++;
        }
    }

    static boolean isPrimeNumber(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    static boolean isPalindrome(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
