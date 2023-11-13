package christmas.event;

import christmas.menu.MenuItem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import static christmas.event.EventManager.DISCOUNT_ZERO;
import static christmas.event.EventManager.isWithinDecemberEventPeriod;

public class WeekdayEvent {
    private static final int DISCOUNT_PER_DESSERT_PRICE = 2023;

    public int calculateDessertDiscount(List<MenuItem> orderedItems, int date) {
        LocalDate reservationDate = LocalDate.of(2023, 12, date);
        if (!isWithinDecemberEventPeriod(reservationDate) || isWeekend(reservationDate)) {
            return DISCOUNT_ZERO;
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
