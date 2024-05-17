import java.io.*;
import java.util.*;

public class Main {

    static int max = 0;
    static int now = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            
            int out = Integer.parseInt(st.nextToken());
            int in = Integer.parseInt(st.nextToken());

            now -= out;
            now += in;
            max = Math.max(max, now);
        }

        System.out.print(max);
    }
}
