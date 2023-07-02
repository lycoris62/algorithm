import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i + 1; j++)
                System.out.print("*");
            for (int j = 0; j < 2 * (N - i - 1); j++)
                System.out.print(" ");
            for (int j = 0; j < i + 1; j++)
                System.out.print("*");
            System.out.println();
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - i - 1; j++)
                System.out.print("*");
            for (int j = 0; j < 2 * (i + 1); j++)
                System.out.print(" ");
            for (int j = 0; j < N - i - 1; j++)
                System.out.print("*");
            System.out.println();
        }
    }
}
