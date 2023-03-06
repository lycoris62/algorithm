import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) list.add(Integer.parseInt(br.readLine()));
        
        int res = 0;
        int max = list.get(list.size()-1).intValue();
        
        for (int i = N-2; i >= 0; i--) {
            int e = list.get(i).intValue();
            
            if (e >= max) {
                res += e - max + 1;
                max -= 1;
            } else max = e;
        }
        
        System.out.println(res);
    }
}