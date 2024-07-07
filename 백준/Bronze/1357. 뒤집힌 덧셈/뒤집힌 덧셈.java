import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = Rev(sc.next());
        int Y = Rev(sc.next());

        int answer = Rev(String.valueOf(X + Y));
        System.out.println(answer);
    }

    static int Rev(String string) {
        return Integer.parseInt(new StringBuilder(string).reverse().toString());
    }
}
