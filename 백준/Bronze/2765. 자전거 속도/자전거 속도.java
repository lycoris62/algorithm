import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int i = 1;
        
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double A = Double.parseDouble(st.nextToken());
			double B = Double.parseDouble(st.nextToken());
			double C = Double.parseDouble(st.nextToken());
            
			if (B == 0) {
				break;
			}
            
			C = (C / 60) / 60;
			double distance = ((((A * 3.1415927) * B) / 12) / 5280);
			double MPH = distance / C; 
			
			System.out.print("Trip #" + i + ": ");
			System.out.print(String.format("%.2f", distance) + " ");
			System.out.print(String.format("%.2f", MPH));
			System.out.println();
			
			i++;
		}
	}
}