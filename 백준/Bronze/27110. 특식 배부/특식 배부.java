import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        A = stoi(st.nextToken());
        B = stoi(st.nextToken());
        C = stoi(st.nextToken());

        System.out.println(Math.min(N, A) + Math.min(N, B) + Math.min(N, C));
    }
}
