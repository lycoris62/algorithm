import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String word = br.readLine();

        int strLen = str.length();
        int wordLen = word.length();
        int newStrLen = str.replace(word, "").length();

        System.out.println((strLen - newStrLen) / wordLen);
    }
}
