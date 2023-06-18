import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int ax = stoi(st.nextToken());
        int ay = stoi(st.nextToken());
        int az = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int cx = stoi(st.nextToken());
        int cy = stoi(st.nextToken());
        int cz = stoi(st.nextToken());

        int bx = cx - az;
        int by = cy / ay;
        int bz = cz - ax;

        System.out.printf("%d %d %d", bx, by, bz);
    }
}
