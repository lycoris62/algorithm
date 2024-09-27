import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		int N = Integer.parseInt(st.nextToken());
        
		long count = 0;
        st = new StringTokenizer(br.readLine());
		long size = Long.parseLong(br.readLine());
        
		for (int i = 0; i < N; i++) {
			long file = Long.parseLong(st.nextToken());
			
			if (file != 0) {
				count += file / size;
				if (file % size != 0) {
					count++;
				}
			}
		}
        
		System.out.println(size * count);
	}
}