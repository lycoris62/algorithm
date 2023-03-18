import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        long temp = 0;

        for (int i = 0; i < str.length(); i++) {
            temp = (temp * 10 + (str.charAt(i) - '0')) % 20000303;
        }
        System.out.println(temp);
    }
}