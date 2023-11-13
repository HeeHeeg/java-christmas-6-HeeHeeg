package christmas.event;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static christmas.event.EventManager.isWithinDecemberEventPeriod;

public class SpecialDiscountEvent {
    private static final int DISCOUNT = 1000;
    private static final int DISCOUNT_ZERO = 0;
    private static final int SPECIAL_DAY = 25;

    public int calculateSpecialDiscount(int date) {
        LocalDate reservationDate = LocalDate.of(2023, 12, date);
        if (!isWithinDecemberEventPeriod(reservationDate)) {
            return DISCOUNT_ZERO;
        }
        if (date == SPECIAL_DAY || reservationDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return DISCOUNT;
        }
        return DISCOUNT_ZERO;
    }
}
