import java.io.*;;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int Csum = 0;
			double Gave = 0;
			
			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
                
				int C = Integer.parseInt(st.nextToken());
				double G = Double.parseDouble(st.nextToken());
				
				Csum += C;
				Gave += (G * C);
			}
			
			System.out.println(Csum + " " + String.format("%.1f", (Gave / Csum)));
		}
	}
}
