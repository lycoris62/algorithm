import java.io.*;

public class Main {

    static int N, M, total;
    static int min = Integer.MAX_VALUE;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        M = stoi(br.readLine());
        N = stoi(br.readLine());

        for (int i = 1; i * i <= N; i++) {
            int x = i * i;

            if (M <= x && x <= N) {
                min = Math.min(min, x);
                total += x;
            }
        }

        System.out.println(total == 0 ? -1 : total + "\n" + min);
    }
}
