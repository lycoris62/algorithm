import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String N = st.nextToken();
        st = new StringTokenizer(br.readLine(), " ");

        int cnt = 0;
        while (st.hasMoreTokens()) {
            if (st.nextToken().equals(N)) cnt++;
        }

        System.out.println(cnt);
    }
}
