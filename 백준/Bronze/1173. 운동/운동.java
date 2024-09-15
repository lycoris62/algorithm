import java.io.*;
import java.util.*;

public class Main {
    
    static int N, m, M, T, R;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

        int mix = m;
		int count = 0;
        
		if ((M - m) < T) {
			System.out.println(-1);
            return;
		} 
        
        while(true) {
            if ((m + T) <= M) {
                m += T;
                N--;
            } else {
                m -= R;
            }

            if (m < mix) {
                m = mix;
            }

            count++;

            if (N == 0) break;
        }

        System.out.println(count);
	}
}