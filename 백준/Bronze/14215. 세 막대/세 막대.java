import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int maxN = 0;
        if(a > b){
            if(b>c) maxN = a;
            else maxN = (a>c) ? a : c;
        } else maxN = (b>c) ? b : c;

        if(a+b+c-maxN > maxN) System.out.println(a+b+c);
        else System.out.print((a+b+c-maxN)*2-1);
    }
}