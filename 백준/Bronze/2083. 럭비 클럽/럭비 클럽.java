import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String s = st.nextToken();
            if (s.equals("#")) break;
            int age = stoi(st.nextToken());
            int weight = stoi(st.nextToken());

            if (age > 17 || weight >= 80) System.out.printf("%s Senior\n", s);
            else System.out.printf("%s Junior\n", s);
        }
    }
}