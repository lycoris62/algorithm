import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int answer = 0;
    static boolean[][] board = new boolean[100][100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = stoi(st.nextToken());
            int y1 = stoi(st.nextToken());

            int x2 = stoi(st.nextToken());
            int y2 = stoi(st.nextToken());

            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    board[j][k] = true;
                }
            }
        }

        for (boolean[] row : board) {
            for (boolean bool : row) {
                if (bool) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
