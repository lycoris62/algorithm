import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int F = sc.nextInt();

        N /= 100;
        N *= 100;

        int num = 0;

        while (N % F != 0) {
            N++;
            num++;
        }

        System.out.println(String.format("%2s", num).replace(" ", "0"));
    }
}
