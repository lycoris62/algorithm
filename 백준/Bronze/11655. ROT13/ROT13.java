import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];

            if (!Character.isLetter(ch)) {
                continue;
            }

            int n = ch + 13;

            if ((Character.isUpperCase(ch) && n > 'Z') || (Character.isLowerCase(ch) && n > 'z')) {
                n -= 26;
            }

            chars[i] = (char) n;
        }

        System.out.println(chars);
    }
}
