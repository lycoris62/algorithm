import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    
    static int N = 0;
    static BigInteger K, L;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
        K = new BigInteger(st.nextToken());
        L = new BigInteger(st.nextToken());
        
		for (int i = 2; i < L.intValue(); i++) {
			if ((K.remainder(BigInteger.valueOf(i))).compareTo(BigInteger.ZERO) == 0) {
				N = i;
				break;
			}
		}
        
		System.out.println((N > 0) ? ("BAD " + N) : "GOOD");
	}
}