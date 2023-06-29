import java.io.*;

public class Main {
    static long S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = Long.parseLong(br.readLine());
        // (1 + N) * N / 2 = S
        System.out.println(((long) Math.sqrt(8 * S + 1) - 1) / 2);
    }
}
