import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        System.out.println((12 <= N && N <= 16) && (M == 0) ? 320 : 280);
    }
}
