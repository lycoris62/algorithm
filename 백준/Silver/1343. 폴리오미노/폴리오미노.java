import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] arr = str.toCharArray();
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'X') {
                cnt++;
                continue;
            }
            if (!(cnt % 2 == 0)) {
                System.out.println(-1);
                return;
            }
            int start = i - cnt;
            for (int j = start; j < start + (cnt / 4) * 4; j++) {
                arr[j] = 'A';
            }
            for (int j = start + (cnt / 4) * 4; j < start + (cnt / 4) * 4 + cnt % 4; j++) {
                arr[j] = 'B';
            }
            cnt = 0;
        }
        if (!(cnt % 2 == 0)) {
            System.out.println(-1);
            return;
        }
        int start = arr.length - cnt;
        for (int i = start; i < start + (cnt / 4) * 4; i++) {
            arr[i] = 'A';
        }
        for (int i = start + (cnt / 4) * 4; i < start + (cnt / 4) * 4 + cnt % 4; i++) {
            arr[i] = 'B';
        }
        
        System.out.println(arr);
    }
}
