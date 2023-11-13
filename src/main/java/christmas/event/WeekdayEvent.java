package christmas.event;

import christmas.menu.MenuItem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class WeekdayEvent {
    private static final int DISCOUNT_PER_DESSERT_PRICE = 2023;
    private static LocalDate WEEKDAY_EVENT_START_DATE = LocalDate.of(2023, 12, 1);
    private static LocalDate WEEKDAY_EVENT_END_DATE = LocalDate.of(2023, 12, 31);

    public int calculateDessertDiscount(List<MenuItem> orderedItems, int date) {
        LocalDate reservationDate = LocalDate.of(2023, 12, date);
        if (reservationDate.isBefore(WEEKDAY_EVENT_START_DATE)
                || reservationDate.isAfter(WEEKDAY_EVENT_END_DATE)
                || isWeekend(reservationDate)) {
            return 0;
        }
        return calculateDiscountForDesserts(orderedItems);
    }

    private boolean isWeekend(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }


    public int calculateDiscountForDesserts(List<MenuItem> orderedItems) {
        int dessertCount = 0;

        for (MenuItem orderedItem : orderedItems) {
            dessertCount += orderedItem.countDessert();
        }
        return dessertCount * DISCOUNT_PER_DESSERT_PRICE;
    }
}
