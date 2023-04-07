import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int L, P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        L = stoi(st.nextToken());
        P = stoi(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            int x = stoi(st.nextToken());
            System.out.printf("%d ", x - L * P);
        }
    }
}
