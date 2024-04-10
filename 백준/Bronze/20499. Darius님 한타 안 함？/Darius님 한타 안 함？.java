import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] kda = Arrays.stream(sc.nextLine().split("/")).mapToInt(Integer::parseInt).toArray();
        System.out.println(kda[0] + kda[2] < kda[1] || kda[1] == 0 ? "hasu" : "gosu");
    }
}
