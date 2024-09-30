import java.io.*;

public class Main {

    static boolean flag;
    static char prev;
    static int count;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String word = br.readLine();

            if (word.equals("end")) {
                break;
            }

            prev = '.';
            count = 0;
            flag = false;

            sb.append("<").append(word);

            for (char ch : word.toCharArray()) {
                if (isVowel(ch)) {
                    flag = true;
                }

                if (isVowel(ch) != isVowel(prev)) {
                    count = 1;
                } else {
                    count++;
                }

                if (count > 2 || ((prev == ch) && (ch != 'e' && ch != 'o'))) {
                    flag = false;
                    break;
                }

                prev = ch;
            }

            sb.append("> is ")
                    .append(flag ? "acceptable." : "not acceptable.")
                    .append("\n");
        }

        System.out.println(sb);
    }

    static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
