import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
        
		String d = "";
        
		d += a;
		d += b;
        
		int e = Integer.parseInt(d);
		
		System.out.println(a + b - c);
		System.out.println(e - c);
	}
}