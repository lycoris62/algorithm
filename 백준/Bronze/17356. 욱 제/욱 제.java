import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sb = new StringTokenizer(br.readLine());
        
        int numA = Integer.parseInt(sb.nextToken());
        int numB = Integer.parseInt(sb.nextToken());

        final double numP = 1 / (1 + Math.pow(10, (numB - numA) / 400.0));

        System.out.print(numP);
    }
}
