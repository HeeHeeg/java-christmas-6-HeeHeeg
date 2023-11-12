package christmas.event;

import java.time.LocalDate;

public class ChristmasDiscountEvent {
    private static LocalDate CHRISTMAS_EVENT_START_DATE = LocalDate.of(2023, 12, 1);
    private static LocalDate CHRISTMAS_EVENT_END_DATE = LocalDate.of(2023, 12, 25);
    private static int BASE_DISCOUNT = 1000;

    public int calculateDiscount(int date) {
        LocalDate reservationDate = LocalDate.of(2023, 12, date);
        if (reservationDate.isBefore(CHRISTMAS_EVENT_START_DATE) || reservationDate.isAfter(CHRISTMAS_EVENT_END_DATE)) {
            return 0;
        }
        long daysBetween = CHRISTMAS_EVENT_START_DATE.until(reservationDate).getDays();
        return BASE_DISCOUNT + (int)daysBetween * 100;
    }
}
