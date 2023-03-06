import java.io.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int n = stoi(br.readLine());
            if (n == 0) break;
            int res = 0;
            for (int i = 1; i <= n; i++) res += i;
            System.out.println(res);
        }
    }
}
