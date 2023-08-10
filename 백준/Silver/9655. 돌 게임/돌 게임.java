import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int turn = 0;
    static String[] arr = {"SK", "CY"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());

        turn = N / 3;
        N %= 3;
        turn += N % 2;
        turn++;
        System.out.println(arr[turn % 2]);
    }
}
