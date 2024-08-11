import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        
        int total = 0; 
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            
            int student = Integer.parseInt(st.nextToken());
            int apple = Integer.parseInt(st.nextToken());
            
            total += apple % student;
        }
        
        System.out.print(total);
    }
}