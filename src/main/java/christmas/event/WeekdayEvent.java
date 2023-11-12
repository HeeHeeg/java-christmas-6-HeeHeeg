package christmas.event;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekdayEvent {
    private static LocalDate CHRISTMAS_EVENT_START_DATE = LocalDate.of(2023, 12, 1);
    private static LocalDate CHRISTMAS_EVENT_END_DATE = LocalDate.of(2023, 12, 31);

    public boolean checkWeekdayDiscountPeriod(int date) {
        LocalDate reservationDate = LocalDate.of(2023, 12, date);
        if (reservationDate.isBefore(CHRISTMAS_EVENT_START_DATE) || reservationDate.isAfter(CHRISTMAS_EVENT_END_DATE)) {
            return false;
        }

        DayOfWeek dayOfWeek = reservationDate.getDayOfWeek();
        return dayOfWeek != DayOfWeek.FRIDAY && dayOfWeek != DayOfWeek.SATURDAY;
    }
}
