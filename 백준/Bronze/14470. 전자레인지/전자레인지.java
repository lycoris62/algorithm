import java.io.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int A, B, C, D, E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = stoi(br.readLine());
        B = stoi(br.readLine());
        C = stoi(br.readLine());
        D = stoi(br.readLine());
        E = stoi(br.readLine());

        int ans = A < 0
                ? -A * C + D + B * E
                : (B - A) * E;

        System.out.println(ans);
    }
}
