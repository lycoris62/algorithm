import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, maxWidth = 0, maxHeight = 0, maxWidthIdx, maxHeightIdx;
    static int[] dirs = new int[6];
    static int[] lens = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());

            dirs[i] = stoi(st.nextToken());
            lens[i] = stoi(st.nextToken());

            if (dirs[i] == 1 || dirs[i] == 2) {
                if (maxWidth < lens[i]) {
                    maxWidth = lens[i];
                    maxWidthIdx = i;
                }
            } else {
                if (maxHeight < lens[i]) {
                    maxHeight = lens[i];
                    maxHeightIdx = i;
                }
            }
        }

        int maxArea = maxWidth * maxHeight;
        int minArea = lens[(maxWidthIdx + 3) % 6] * lens[(maxHeightIdx + 3) % 6];

        System.out.println(N * (maxArea - minArea));
    }
}
