import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int M, D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = stoi(st.nextToken());
        D = stoi(br.readLine());

        if (M == 2 && D == 18) {
            System.out.println("Special");
        } else if (M < 2 || (M == 2 && D < 18)) {
            System.out.println("Before");
        } else {
            System.out.println("After");
        }
    }
}
