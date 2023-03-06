import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = stoi(st.nextToken());
        
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = i + 1;
        
        perm(arr, new int[N], new boolean[N], 0, N, N);
        bw.close();
    }

    static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) throws IOException {
        if (depth == r) {
            for (int i : output) bw.write(i + " ");
            bw.write("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }

    }
}
