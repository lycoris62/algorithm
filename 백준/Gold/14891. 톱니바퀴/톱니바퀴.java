import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int K;
    static boolean[] visited;
    static Gear[] gears = new Gear[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            gears[i] = new Gear(i - 1);
            String state = br.readLine();

            for (int j = 0; j < 8; j++) {
                gears[i].state[j] = state.charAt(j) - '0';
            }
        }

        K = stoi(br.readLine());

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int gearNum = stoi(st.nextToken()) - 1;
            int rotateDir = stoi(st.nextToken());

            visited = new boolean[4];
            rec(gearNum, rotateDir);
        }

        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (gears[i].state[0] == 1) {
                score += (int) Math.pow(2, i);
            }
        }

        System.out.println(score);
    }

    static void rec(int now, int rotate) {
        if (now == 4 || now == -1) {
            return;
        }

        Gear nowGear = gears[now];
        visited[now] = true;

        if (now + 1 < 4 && !visited[now + 1]) {
            Gear nextRightGear = gears[now + 1];

            if (nowGear.getRight() != nextRightGear.getLeft()) {
                rec(now + 1, -rotate);
            }
        }

        if (now - 1 >= 0 && !visited[now - 1]) {
            Gear nextLeftGear = gears[now - 1];

            if (nowGear.getLeft() != nextLeftGear.getRight()) {
                rec(now - 1, -rotate);
            }
        }

        nowGear.rotate(rotate);
    }

    static class Gear {

        int num;
        int[] state = new int[8];

        public Gear(int num) {
            this.num = num;
        }

        public void rotate(int rotateNum) {
            if (rotateNum == 1) {
                rotateClockwise();
            } else {
                rotateCounterClockwise();
            }
        }

        private void rotateClockwise() {
            int temp = state[7];
            for (int i = 7; i > 0; i--) {
                state[i] = state[i - 1];
            }
            state[0] = temp;
        }

        private void rotateCounterClockwise() {
            int temp = state[0];
            for (int i = 0; i < 7; i++) {
                state[i] = state[i + 1];
            }
            state[7] = temp;
        }

        public int getRight() {
            return state[2];
        }

        public int getLeft() {
            return state[6];
        }
    }
}
