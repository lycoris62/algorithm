import java.io.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int x = stoi(br.readLine());
            sum += Math.max(x, 40);
        }
        
        System.out.println(sum / 5);
    }
}