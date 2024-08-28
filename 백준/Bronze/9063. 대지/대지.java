import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int minWidth = Integer.MAX_VALUE, maxWidth = Integer.MIN_VALUE;
    static int minHeight = Integer.MAX_VALUE, maxHeight = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = stoi(st.nextToken());
            int y = stoi(st.nextToken());

            minWidth = Math.min(minWidth, x);
            maxWidth = Math.max(maxWidth, x);

            minHeight = Math.min(minHeight, y);
            maxHeight = Math.max(maxHeight, y);
        }

        System.out.println((maxWidth - minWidth) * (maxHeight - minHeight));
    }
}

