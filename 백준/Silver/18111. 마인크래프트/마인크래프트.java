import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int M, N, B, time = Integer.MAX_VALUE, h;
    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    static int[][] land;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        B = stoi(st.nextToken());
        land = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int height = stoi(st.nextToken());
                land[i][j] = height;
                min = Math.min(min, height);
                max = Math.max(max, height);
            }
        }

        for (int height = min; height <= max; height++) {
            int nowTime = 0;
            int block = B;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int nowHeight = land[i][j];
                    if (height < nowHeight) {
                        nowTime += 2 * (nowHeight - height);
                        block += nowHeight - height;
                    } else {
                        nowTime += height - nowHeight;
                        block -= height - nowHeight;
                    }
                }
            }

            if (block < 0) {
                break;
            }

            if (time >= nowTime) {
                time = nowTime;
                h = height;
            }
        }

        System.out.printf("%d %d", time, h);
    }
}
