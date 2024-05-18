import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String num = sc.next();
        int B = sc.nextInt();

        int total = 0;

        for (char ch : num.toCharArray()) {
            int n = '0' <= ch && ch <= '9' ? ch - '0' : ch - 'A' + 10;
            total *= B;
            total += n;
        }

        System.out.println(total);
    }
}
