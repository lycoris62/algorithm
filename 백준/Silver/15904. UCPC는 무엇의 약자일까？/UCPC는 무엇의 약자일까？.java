import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int idx;
    static String str;
    static char[] arr = {'U', 'C', 'P', 'C'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        for (char ch : str.toCharArray()) {
            if (ch == arr[idx]) {
                idx++;
            }

            if (idx == 4) {
                System.out.println("I love UCPC");
                return;
            }
        }

        System.out.println("I hate UCPC");
    }
}
