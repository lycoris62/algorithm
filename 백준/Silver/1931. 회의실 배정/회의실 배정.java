import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] times = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(times, Comparator.comparingInt((int[] arr) -> arr[1]).thenComparingInt((int[] arr) -> arr[0]));

        int res = 1;
        int lastEndTime = times[0][1];
        for (int i = 1; i < N; i++) {
            if (lastEndTime <= times[i][0]) {
                res++;
                lastEndTime = times[i][1];
            }
        }
        System.out.println(res);
    }
}
