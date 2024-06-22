import java.util.Scanner;

public class Main {

    static int[] dpA = new int[46];
    static int[] dpB = new int[46];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        dpA[2] = 1;
        dpB[1] = dpB[2] = 1;

        for (int i = 3; i <= N; i++) {
            dpA[i] = dpA[i - 1] + dpA[i - 2];
            dpB[i] = dpB[i - 1] + dpB[i - 2];
        }

        System.out.println(dpA[N] + " " + dpB[N]);
    }
}
