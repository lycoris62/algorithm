package p11718;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = 100;
        while (N-- > 0) {
            String str = br.readLine();
            if (str == null || str.isEmpty()) break;
            bw.write(str + "\n");
        }
        bw.close();
    }
}
