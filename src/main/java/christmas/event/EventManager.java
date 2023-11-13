package christmas.event;

import java.time.LocalDate;

public class EventManager {
    public static LocalDate CHRISTMAS_EVENT_START_DATE = LocalDate.of(2023, 12, 1);
    public static LocalDate CHRISTMAS_EVENT_END_DATE = LocalDate.of(2023, 12, 25);
    public static LocalDate DECEMBER_EVENT_START_DATE = LocalDate.of(2023, 12, 1);
    public static LocalDate DECEMBER_EVENT_END_DATE = LocalDate.of(2023, 12, 31);
    public static int DISCOUNT_ZERO = 0;

    public static boolean isWithinChristmasEventPeriod(LocalDate date) {
        return !date.isBefore(CHRISTMAS_EVENT_START_DATE) && !date.isAfter(CHRISTMAS_EVENT_END_DATE);
    }

    public static boolean isWithinDecemberEventPeriod(LocalDate date) {
        return !date.isBefore(DECEMBER_EVENT_START_DATE) && !date.isAfter(DECEMBER_EVENT_END_DATE);
    }
}
