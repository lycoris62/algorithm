import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 1000 - sc.nextInt();

        int coins = 0;

        int[] coinArr = {500, 100, 50, 10, 5, 1};
        int idx = 0;

        while (N != 0) {
            int count = N / coinArr[idx];
            coins += count;
            N -= count * coinArr[idx];
            idx++;
        }

        System.out.println(coins);
    }
}
