import java.util.Scanner;

public class Main {

    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            if (i == N - 1) {
                sb.append("*".repeat(2 * N - 1));
                break;
            }
            if (i == 0) {
                sb.append(" ".repeat(N - 1 - i)).append("*").append("\n");
                continue;
            }

            sb
                .append(" ".repeat(N - 1 - i))
                .append("*")
                .append(" ".repeat(2 * i - 1))
                .append("*")
                .append("\n");
        }

        System.out.println(sb);
    }
}
