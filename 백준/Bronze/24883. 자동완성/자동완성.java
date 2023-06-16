import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char c = br.readLine().charAt(0);

        System.out.println(c == 'n' || c == 'N' ? "Naver D2" : "Naver Whale");
    }
}
