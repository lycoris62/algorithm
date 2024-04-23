import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();

        long Z = (100L * Y) / X;

        if (Z == 100) {
            System.out.println(-1);
            return;
        }

        long left = 0;
//        long right = 1_000_000_000 * 1_000L;
        long right = Long.MAX_VALUE / 10000;

        while (left < right) {
            long mid = (left + right) / 2;
            long z = 100 * (Y + mid) / (X + mid);

            if (z > Z) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        long finalZ = 100 * (Y + left) / (X + left);

        if (Z == finalZ) {
            System.out.println(-1);
            return;
        }

        System.out.println(left);
    }
}
