import java.io.*;
import java.util.*;

public class Main {
    static double stoi(String s) {
        return Double.parseDouble(s);
    }

    static double A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        A = stoi(st.nextToken());
        B = stoi(st.nextToken());
        C = stoi(st.nextToken());

        int x = (int) ((A * B) / C);
        int y = (int) ((A / B) * C);

        System.out.println(Math.max(x, y));
    }
}
