import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int X = stoi(st.nextToken());
            int Y = stoi(st.nextToken());

            sb.append(X >= Y ? "MMM BRAINS" : "NO BRAINS").append("\n");
        }

        System.out.println(sb);
    }
}
