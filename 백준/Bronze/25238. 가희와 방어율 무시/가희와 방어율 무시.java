import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        a = stoi(st.nextToken());
        b = stoi(st.nextToken());
        System.out.println((a * (100 - b) / 100 < 100) ? 1 : 0);
    }
}
