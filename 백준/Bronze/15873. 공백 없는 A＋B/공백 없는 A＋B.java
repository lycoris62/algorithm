import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        int len = input.length();

        if (len == 4) {
            System.out.println(20);
        } else if (len == 2) {
            System.out.println(Integer.parseInt(input.substring(0, 1)) + Integer.parseInt(input.substring(1)));
        } else {
            String sub = input.substring(0, 2);

            if (sub.equals("10")) {
                System.out.println(10 + Integer.parseInt(input.substring(2)));
            } else {
                System.out.println(Integer.parseInt(input.substring(0, 1)) + 10);
            }
        }
    }
}
