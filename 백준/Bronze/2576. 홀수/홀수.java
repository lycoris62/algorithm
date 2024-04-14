import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[7];

        for (int i = 0; i < 7; i++) {
            arr[i] = sc.nextInt();
        }

        int[] oddArr = Arrays.stream(arr).filter(x -> x % 2 == 1).toArray();

        if (oddArr.length == 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(Arrays.stream(oddArr).sum());
        System.out.println(Arrays.stream(oddArr).min().getAsInt());
    }
}
