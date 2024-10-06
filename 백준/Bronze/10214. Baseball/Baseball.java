import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int Y = 0;
			int K = 0;
			for (int j = 0; j < 9; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
                
				Y += Integer.parseInt(st.nextToken());
				K += Integer.parseInt(st.nextToken());
			}
            
			if (Y > K) {
				System.out.println("Yonsei");
			} else if(K > Y) {
				System.out.println("Korea");
			} else {
				System.out.println("Draw");
			}
		}
	}
}