import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int coins = N / 5;
        int money = N % 5;

        while (money <= N) {
            coins += money / 2;
            money %= 2;

            if (money == 0) {
                System.out.println(coins);
                return;
            }

            money += 5;
            coins--;
        }

        System.out.println(-1);
    }
}
