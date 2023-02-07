import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), "+-", true);
        List<String> list = new ArrayList<>();
        while (st.hasMoreTokens()) list.add(st.nextToken());

        int res = 0;
        boolean isFlag = false;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("-")) isFlag = true;
            else if (!list.get(i).equals("+")) res += (isFlag ? -1 : 1) * Integer.parseInt(list.get(i));
        }
        
        System.out.println(res);
    }
}
