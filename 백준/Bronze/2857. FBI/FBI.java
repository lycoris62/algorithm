import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = "";
        
		for (int i = 1; i <= 5; i++) {
			if (br.readLine().contains("FBI")) {
                str += i + " ";
            }
		}
        
		System.out.println(str != "" ? str.trim() : "HE GOT AWAY!");
	}
}