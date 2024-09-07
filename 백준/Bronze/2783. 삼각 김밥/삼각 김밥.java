import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		double X = Double.parseDouble(st.nextToken());
		double Y = Double.parseDouble(st.nextToken());
		double R = (1000 / Y) * X;
		
		int N = Integer.parseInt(br.readLine());
        
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
            
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			double r = (1000 / y) * x;
			
			R = Math.min(R, r);
		}
        
		System.out.println(String.format("%.2f", R));
	}
}