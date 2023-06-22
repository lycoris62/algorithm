import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = stoi(st.nextToken());
        }

        if (getY() == getM()) {
            System.out.println("Y M " + getY());
        } else if (getY() > getM()) {
            System.out.println("M " + getM());
        } else {
            System.out.println("Y " + getY());
        }
    }

    static int getY() {
        int res = 0;
        for (int x : arr) {
            res += (x / 30 + 1) * 10;
        }

        return res;
    }

    static int getM() {
        int res = 0;
        for (int x : arr) {
            res += (x / 60 + 1) * 15;
        }

        return res;
    }
}
