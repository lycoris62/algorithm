import java.io.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = stoi(br.readLine());
        B = stoi(br.readLine());
        C = stoi(br.readLine());
        if (A + B + C != 180) {
            System.out.println("Error");
            return;
        }
        if (A == 60 && B == 60 && C == 60) {
            System.out.println("Equilateral");
            return;
        }
        if ((A != B) && (A != C) && (B != C)) {
            System.out.println("Scalene");
        } else {
            System.out.println("Isosceles");
        }
    }
}
