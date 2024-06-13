import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        int count = 0;
        int total = 0;

        for (int i = 1; i <= B; i++) {
            for (int j = 1; j <= i; j++) {
                count++;

                if (A <= count && count <= B) {
                    total += i;
                }
            }
        }

        System.out.println(total);
    }
}
