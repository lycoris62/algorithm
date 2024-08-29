import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, R, E, C;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            R = stoi(st.nextToken());
            E = stoi(st.nextToken());
            C = stoi(st.nextToken());

            int after = E - C;

            sb.append(R == after ? "does not matter" : (R > after ? "do not advertise" : "advertise")).append("\n");
        }

        System.out.println(sb);
    }
}
