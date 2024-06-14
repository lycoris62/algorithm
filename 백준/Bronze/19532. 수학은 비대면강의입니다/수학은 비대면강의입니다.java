import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();
        int E = sc.nextInt();
        int F = sc.nextInt();

        // ax + by = c
        // dx + ey = f

        // aex + bey = ce
        // bdx + bey = bf

        // x = (ce - bf) / (ae - bd)

        // adx + bdy = cd
        // adx + aey = af

        // y = (af - cd) / (ae - bd)

        int AE_BD = A * E - B * D;

        int CE_BF = C * E - B * F;
        int AF_CD = A * F - C * D;

        int X = CE_BF / AE_BD;
        int Y = AF_CD / AE_BD;

        System.out.println(X + " " + Y);
    }
}
