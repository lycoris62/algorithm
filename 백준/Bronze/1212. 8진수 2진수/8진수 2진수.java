import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String eight = sc.next();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < eight.length(); i++) {
            int target = eight.charAt(i) - '0';

            String binary = Integer.toBinaryString(target);

            if (binary.length() == 3) {
                sb.append(binary);
            } else if (binary.length() == 2 && i != 0) {
                sb.append("0").append(binary);
            } else if (binary.length() == 1 && i != 0) {
                sb.append("00").append(binary);
            } else {
                sb.append(binary);
            }
        }

        System.out.println(sb);
    }
}
