import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		if (N % 8 == 0) {
			System.out.println(2);
		} else if (N % 4 == 3) {
			System.out.println(3);
		} else if (N % 8 == 6) {
			System.out.println(4);
		} else {
			System.out.println(N % 8);
		}
	}
}