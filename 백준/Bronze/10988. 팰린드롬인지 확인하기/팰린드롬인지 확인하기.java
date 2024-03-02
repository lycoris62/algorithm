import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.next();
        int len = word.length();

        boolean isPalindrome = true;

        for (int i = 0; i < len / 2; i++) {
            char front = word.charAt(i);
            char rear = word.charAt(len - 1 - i);

            if (front != rear) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println(isPalindrome ? 1 : 0);
    }
}
