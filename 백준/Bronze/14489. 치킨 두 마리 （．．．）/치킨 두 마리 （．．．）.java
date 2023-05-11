import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        A = stoi(st.nextToken());
        B = stoi(st.nextToken());
        C = stoi(br.readLine());

        int money = (A + B - 2 * C >= 0) ? A + B - 2 * C : A + B;
        System.out.println(money);
    }
}
