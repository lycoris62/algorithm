import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int A = 0, B = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        A += stoi(st.nextToken());
        B += stoi(st.nextToken());
        B += stoi(st.nextToken());
        A += stoi(st.nextToken());

        System.out.println(Math.abs(A - B));
    }
}
