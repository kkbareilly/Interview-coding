package java8.times;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public class TimesOps {
    public static void main(String[] args) {
        OffsetDateTime offsetDT = OffsetDateTime.now();
        LocalDateTime local=LocalDateTime.now();
        System.out.println(offsetDT.getMonth());

        System.out.println(offsetDT.getDayOfMonth());
        System.out.println(offsetDT.getDayOfYear());
        System.out.println(offsetDT.getDayOfWeek());
        System.out.println(offsetDT.toLocalDate());
    }
}
