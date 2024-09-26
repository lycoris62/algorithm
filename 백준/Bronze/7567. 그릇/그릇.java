import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = bufferedReader.readLine();
        int answer = 10;

        for (int i = 1; i < string.length(); i++){
            answer += string.charAt(i) == string.charAt(i - 1) ? 5 : 10;
        }

        System.out.println(answer);
    }
}
