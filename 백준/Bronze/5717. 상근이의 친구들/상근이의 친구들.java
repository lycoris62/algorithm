import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());

            if (a == 0 && b == 0) {
                break;
            }

            System.out.println(a + b);
        }

    }
}
