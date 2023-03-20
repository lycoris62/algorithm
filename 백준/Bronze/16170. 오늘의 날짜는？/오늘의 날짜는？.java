import java.io.*;
import java.time.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ZonedDateTime date = ZonedDateTime.now(ZoneOffset.of("+00:00"));
        System.out.println(date.getYear());
        System.out.println(date.getMonthValue());
        System.out.println(date.getDayOfMonth());
    }
}
