import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        int last = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String[] s = str.split(" ");
            String op = s[0];
            if (op.equals("pop")) {
                if (q.isEmpty()) bw.write(-1 + "\n");
                else bw.write(q.poll() + "\n");
            } else if (op.equals("push")) {
                last = Integer.parseInt(s[1]);
                q.offer(last);
            }
            else if (op.equals("size")) bw.write(q.size() + "\n");
            else if (op.equals("empty")) {
                if (q.isEmpty()) bw.write("1\n");
                else bw.write("0\n");
            } else if (op.equals("front")) {
                if (q.isEmpty()) bw.write(-1 + "\n");
                else bw.write(q.peek() + "\n");
            } else if (op.equals("back")) {
                if (q.isEmpty()) bw.write(-1 + "\n");
                else bw.write(last + "\n");
            }
        }
        bw.close();
    }
}
