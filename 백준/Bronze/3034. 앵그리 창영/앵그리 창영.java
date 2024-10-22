import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if (n <= W) {
				System.out.println("DA");
			} else if (n <= H) {
				System.out.println("DA");
			} else if (n <= Math.sqrt(Math.pow(W, 2) + Math.pow(H, 2))) {
				System.out.println("DA");
			} else {
				System.out.println("NE");
			}
		}
	}
}