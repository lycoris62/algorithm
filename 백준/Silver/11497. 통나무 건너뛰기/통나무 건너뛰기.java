import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T, N;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = stoi(st.nextToken());

        while (T-- > 0) {
            N = stoi(br.readLine());
            arr = new int[N];
            int[] temp = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = stoi(st.nextToken());
            }

            Arrays.sort(arr);

            for (int i = 0; i < arr.length; i++) {
                int x = N / 2 + (i % 2 == 0 ? 1 : -1) * ((i + 1) / 2);
                temp[x] = arr[i];
            }
            
            temp[N] = temp[0];
            int ans = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {
                ans = Math.max(ans, Math.abs(temp[i] - temp[i + 1]));
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}
