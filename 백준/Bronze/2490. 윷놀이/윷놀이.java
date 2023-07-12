import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static char[] arr = {'E', 'A', 'B', 'C', 'D'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int cnt = 0;

            while (st.hasMoreTokens()) {
                if (stoi(st.nextToken()) == 0) cnt++;
            }

            System.out.println(arr[cnt]);
        }

    }
}
