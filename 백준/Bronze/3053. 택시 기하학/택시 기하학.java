import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        System.out.println(String.format("%.6f", Math.PI * N * N));
        System.out.println(String.format("%.6f", 2.0d * N * N));
    }
}
