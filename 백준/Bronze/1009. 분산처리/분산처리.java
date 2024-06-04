import java.util.Scanner;

public class Main {

    static int a, b, answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int T = s.nextInt();

        for (int j = 0; j < T; j++) {
            a = s.nextInt();
            b = s.nextInt();
            answer = 1;

            for (int i = 0; i < b; i++) {
                answer = (answer * a) % 10;
            }

            if (answer == 0) {
                answer = 10;
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
