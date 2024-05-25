import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] arr = new int[3];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            for (int i = 0; i < 3; i++) {
                arr[i] = sc.nextInt();
            }

            if (arr[0] == 0) {
                break;
            }

            Arrays.sort(arr);

            if (arr[0] + arr[1] <= arr[2]) {
                sb.append("Invalid").append("\n");
                continue;
            }

            if (arr[0] == arr[1] && arr[1] == arr[2]) {
                sb.append("Equilateral").append("\n");
            } else if (arr[0] != arr[1] && arr[1] != arr[2]) {
                sb.append("Scalene").append("\n");
            } else {
                sb.append("Isosceles").append("\n");
            }
        }

        System.out.println(sb);
    }
}
