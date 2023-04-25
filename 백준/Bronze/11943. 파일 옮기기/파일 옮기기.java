import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int a1, a2, b1, b2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        a1 = stoi(st.nextToken());
        b1 = stoi(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");
        a2 = stoi(st.nextToken());
        b2 = stoi(st.nextToken());

        System.out.println(Math.min(a1 + b2, a2 + b1));
    }
}
