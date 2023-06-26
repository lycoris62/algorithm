import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static int[] res = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        for (int x : arr) {
            switch (x) {
                case 9:
                case 6:
                    if (res[9] >= res[6]) res[6]++;
                    else res[9]++;
                    break;
                default:
                    res[x]++;
                    break;
            }
        }

        System.out.println(Arrays.stream(res).max().getAsInt());
    }
}
