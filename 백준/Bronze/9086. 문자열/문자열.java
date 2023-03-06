import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());

        while (N-- > 0) {
            String str = br.readLine();
            System.out.printf("%c%c\n",str.charAt(0),str.charAt(str.length() - 1));
        }
    }
}
