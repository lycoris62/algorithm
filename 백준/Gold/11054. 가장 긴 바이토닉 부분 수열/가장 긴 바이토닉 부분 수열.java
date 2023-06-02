import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] nums, dpLeft, dpRight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        nums = new int[N + 1];
        dpLeft = new int[N + 1];
        dpRight = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            nums[i] = stoi(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            dpLeft[i] = 1;
            for (int j = 1; j < i; j++) {
                if (nums[i] > nums[j] && dpLeft[i] <= dpLeft[j]) {
                    dpLeft[i] = dpLeft[j] + 1;
                }
            }
        }

        for (int i = N; i >= 1; i--) {
            dpRight[i] = 0;
            for (int j = N; j > i; j--) {
                if (nums[i] > nums[j] && dpRight[i] <= dpRight[j]) {
                    dpRight[i] = dpRight[j] + 1;
                }
            }
            dpLeft[i] += dpRight[i];
        }

        System.out.println(Arrays.stream(dpLeft).max().getAsInt());
    }
}
