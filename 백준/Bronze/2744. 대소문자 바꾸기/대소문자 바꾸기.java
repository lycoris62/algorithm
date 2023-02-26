import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = Character.isUpperCase(str.charAt(i)) ? Character.toLowerCase(str.charAt(i)) : Character.toUpperCase(str.charAt(i));
            sb.append(c);
        }
        
        System.out.println(sb);
    }
}
