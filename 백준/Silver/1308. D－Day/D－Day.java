import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LocalDate start = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
        LocalDate end = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());

        long years = ChronoUnit.YEARS.between(start, end);

        if (years >= 1000) {
            System.out.println("gg");
            return;
        }

        System.out.println("D-" + ChronoUnit.DAYS.between(start, end));
    }
}
