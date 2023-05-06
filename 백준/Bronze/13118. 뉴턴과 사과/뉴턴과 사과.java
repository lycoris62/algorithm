import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] p = new int[4];
        p[0] = stoi(st.nextToken());
        p[1] = stoi(st.nextToken());
        p[2] = stoi(st.nextToken());
        p[3] = stoi(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int x = stoi(st.nextToken());
        int y = stoi(st.nextToken());
        int r = stoi(st.nextToken());
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            if (p[i] == x) ans = i + 1;
        }
        System.out.println(ans);
    }
}
