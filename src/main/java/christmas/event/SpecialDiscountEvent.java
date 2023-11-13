package christmas.event;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class SpecialDiscountEvent {
    private static LocalDate SPECIAL_EVENT_START_DATE = LocalDate.of(2023, 12, 1);
    private static LocalDate SPECIAL_EVENT_END_DATE = LocalDate.of(2023, 12, 31);
    private static int DISCOUNT = 1000;


    public int calculateSpecialDiscount(int date) {
        LocalDate reservationDate = LocalDate.of(2023, 12, date);
        if (reservationDate.isBefore(SPECIAL_EVENT_START_DATE)
                || reservationDate.isAfter(SPECIAL_EVENT_END_DATE)) {
            return 0;
        }
        if (date == 25 || reservationDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return DISCOUNT;
        }
        return 0;
    }
}
