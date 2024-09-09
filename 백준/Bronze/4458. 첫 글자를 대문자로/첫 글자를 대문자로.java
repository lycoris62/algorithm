import java.io.*;

public class Main extends Exception {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        String answer = "";

        for (int i = 0; i < num; i++) {
            String str = br.readLine();
            char ch = ' ';

            for (int j = 0; j < str.length(); j++) {
                ch = str.charAt(j);

                if (j == 0) {
                    ch = Character.toUpperCase(str.charAt(0));
                }
                
                sb.append(ch);
            }
            
            sb.append("\n");
        }

        System.out.println(sb);
    }
}