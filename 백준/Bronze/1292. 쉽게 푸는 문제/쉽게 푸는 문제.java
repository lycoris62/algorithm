import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int start = sc.nextInt();
        int end = sc.nextInt();

        int[] sums = new int[end + 1];

        int x = 1;

        OUTER:
        for (int i = 1; i <= end; ) {
            for (int j = 0; j < x; j++) {
                if (i > end) {
                    break OUTER;
                }
                sums[i] = sums[i - 1] + x;
                i++;
            }
            x++;
        }

        System.out.println(sums[end] - sums[start - 1]);
    }
}
