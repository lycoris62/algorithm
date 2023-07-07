import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            if (i != 0 && i % 10 == 0) {
                sb.append("\n");
            }
            sb.append(str.charAt(i));
        }
        System.out.println(sb);
    }
}
