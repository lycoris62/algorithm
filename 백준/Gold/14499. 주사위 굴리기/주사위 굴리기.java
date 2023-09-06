import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M, K, X, Y;
    static int[][] graph;
    static int[] dice = {0, 0, 0, 0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        X = stoi(st.nextToken());
        Y = stoi(st.nextToken());
        K = stoi(st.nextToken());

        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                graph[i][j] = stoi(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < K; i++) {
            int order = stoi(st.nextToken());

            if (order == 1) right();
            else if (order == 2) left();
            else if (order == 3) up();
            else down();
        }
    }

    static void up() {
        if (X == 0) return;
        X--;

        int[] temp = Arrays.copyOf(dice, dice.length);

        for (int i = 0; i < 4; i++) {
            dice[i] = temp[(i - 1 + 4) % 4];
        }

        print();
    }

    static void down() {
        if (X == N - 1) return;
        X++;

        int[] temp = Arrays.copyOf(dice, dice.length);

        for (int i = 0; i < 4; i++) {
            dice[i] = temp[(i + 1) % 4];
        }

        print();
    }

    static void right() {
        if (Y == M - 1) return;
        Y++;

        int[] temp = Arrays.copyOf(dice, dice.length);

        dice[1] = temp[5];
        dice[3] = temp[4];
        dice[4] = temp[1];
        dice[5] = temp[3];

        print();
    }

    static void left() {
        if (Y == 0) return;
        Y--;

        int[] temp = Arrays.copyOf(dice, dice.length);

        dice[1] = temp[4];
        dice[3] = temp[5];
        dice[4] = temp[3];
        dice[5] = temp[1];

        print();
    }

    static void print() {
        if (graph[X][Y] == 0) {
            graph[X][Y] = dice[1];
        } else {
            dice[1] = graph[X][Y];
            graph[X][Y] = 0;
        }

        System.out.println(dice[3]);
    }
}
