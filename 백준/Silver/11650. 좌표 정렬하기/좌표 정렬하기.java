import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int[] coord = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list.add(coord);
        }
        list.sort(Comparator.comparingInt((int[] arr) -> arr[0]).thenComparingInt((int[] arr) -> arr[1]));
        for (int[] coord : list) {
            for (int i : coord) {
                bw.write(i + " ");
            }
            bw.write("\n");
        }
        bw.close();
    }
}
