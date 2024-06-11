import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();

        long AB = Long.parseLong(String.valueOf(A) + B);
        long CD = Long.parseLong(String.valueOf(C) + D);

        System.out.println(AB + CD);
    }
}
