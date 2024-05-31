import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int B = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        while (N != 0) {
            if (N % B >= 10) {
                sb.append((char) ((N % B) + 'A' - 10));
            } else {
                sb.append(N % B);
            }

            N /= B;
        }
        
        System.out.println(sb.reverse());
    }
}
