import java.io.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int money, total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while ((money = stoi(br.readLine())) != -1) {
            total += money;
        }

        System.out.println(total);
    }
}
