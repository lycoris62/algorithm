import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] num = new int[st.countTokens()];
            int i = 0;
            
            while (st.hasMoreTokens()) {
                int value = Integer.parseInt(st.nextToken());
                if (value % 2 == 0) {
                    num[i] = value;
                    i++;
                }
            }
            
            int sum = 0;
            int min = num[0];
            for (int j = 0; j < num.length; j++){
                if(num[j] == 0) {
                    break;
                } 
                
                sum += num[j];
                if (min > num[j]) {
                    min = num[j];
                }
            }
            
            System.out.println(sum + " " + min);
        }
    }
}