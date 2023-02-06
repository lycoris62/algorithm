import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(br.readLine().split(" "));
        }
        list.sort(Comparator.comparingInt(o -> Integer.parseInt(o[0])));
        for (int i = 0; i < N; i++) {
            for (String str : list.get(i)) {
                bw.write(str + " ");
            }
            bw.write("\n");
        }
        bw.close();
    }
}
