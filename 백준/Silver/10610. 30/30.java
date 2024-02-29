import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] numCounts = new int[10];

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        long total = 0L;

        for (int i = 0; i < num.length(); i++) {
            int digit = stoi(num.substring(i, i + 1));
            numCounts[digit]++;
            total += digit;
        }

        if (!num.contains("0") || total % 3 != 0) {
            System.out.println("-1");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            while (numCounts[i] > 0) {
                sb.append(i);
                numCounts[i]--;
            }
        }

        System.out.println(sb);
    }
}
