import java.io.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        for (int i = 0; i < 4; i++) sum += stoi(br.readLine());
        
        System.out.println(sum / 60);
        System.out.println(sum % 60);
    }
}
