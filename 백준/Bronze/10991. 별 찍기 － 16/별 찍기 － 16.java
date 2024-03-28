import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int i = N - 1; i >= 0; i--) {
            sb.append(" ".repeat(i)).append("* ".repeat(Math.max(0, N - i))).append("\n");
        }

        System.out.println(sb);
    }
}
