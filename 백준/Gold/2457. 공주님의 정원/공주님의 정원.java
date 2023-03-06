import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            list.add(new int[]{
                    Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken())
            });
        }
        
        list = list.stream().sorted((int[] a, int[] b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            else return a[0] - b[0];
        }).collect(Collectors.toCollection(ArrayList::new));

        int res = 0;
        int idx = 0;
        int start = 301;
        int max = 0;

        while (start < 1201) {
            boolean check = false;
            for (int i = idx; i < N; i++) {
                if (list.get(i)[0] > start) break;
                if (list.get(i)[0] <= start && max < list.get(i)[1]) {
                    max = list.get(i)[1];
                    idx++;
                    check = true;
                }
            }
            if (check) {
                start = max;
                res += 1;
            } else break;
        }
        
        if (max < 1201) System.out.println(0);
        else System.out.println(res);
    }
}
