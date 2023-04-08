import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int H, M, S, D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        H = stoi(st.nextToken());
        M = stoi(st.nextToken());
        S = stoi(st.nextToken());
        D = stoi(br.readLine());

        int total = H * 60 * 60 + M * 60 + S + D;
        total %= 24 * 60 * 60;

        H = total / (60 * 60);
        M = (total % (60 * 60)) / 60;
        S = (total % (60 * 60)) % 60;

        System.out.printf("%d %d %d", H, M, S);
    }
}
