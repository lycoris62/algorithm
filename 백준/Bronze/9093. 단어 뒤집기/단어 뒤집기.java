import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static StringBuffer sb = new StringBuffer();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            
            while (st.hasMoreTokens()) {
                String word = st.nextToken();
                sb.append(new StringBuilder(word).reverse()).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
