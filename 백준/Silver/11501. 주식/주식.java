import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            long[] arr = new long[N];
            
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) arr[j] = Long.parseLong(st.nextToken());

            long res = 0L;
            long max = 0L;

            for (int j = N-1; j >= 0; j--) {
                if (arr[j] > max) max = arr[j];
                else res += max - arr[j];
            }
            
            bw.write(res + "\n");
        }
        bw.close();
    }
}