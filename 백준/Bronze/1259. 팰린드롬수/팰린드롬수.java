import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String str = br.readLine();

            if (str.equals("0")) break;
            boolean isSame = true;

            for (int i = 0; i < str.length() / 2; i++) {
                if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                    isSame = false;
                    break;
                }
            }

            if (isSame) bw.write("yes\n");
            else bw.write("no\n");
        }
        bw.close();
    }
}