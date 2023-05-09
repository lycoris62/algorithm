import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int S, T, D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        S = stoi(st.nextToken());
        T = stoi(st.nextToken());
        D = stoi(st.nextToken());
        System.out.println(T * (D / (2 * S)));
    }
}
