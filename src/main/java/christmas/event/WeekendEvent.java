package christmas.event;

import christmas.menu.MenuItem;

import java.time.LocalDate;
import java.util.List;

import static christmas.event.EventManager.DISCOUNT_ZERO;
import static christmas.event.EventManager.isWithinDecemberEventPeriod;

public class WeekendEvent {
    private static final int DISCOUNT_PER_MAIN_PRICE = 2023;
    private static final EventManager eventManager = new EventManager();

    public int calculateMainDiscount(List<MenuItem> orderedItems, int date) {
        LocalDate reservationDate = LocalDate.of(2023, 12, date);
        if ((isWithinDecemberEventPeriod(reservationDate) && eventManager.isWeekend(reservationDate))) {
            return calculateWeekendDiscount(orderedItems);
        }
        return DISCOUNT_ZERO;
    }


    private int calculateWeekendDiscount(List<MenuItem> orderedItems) {
        int mainCount = 0;

        for (MenuItem orderedItem : orderedItems) {
            mainCount += orderedItem.countMain();
        }
        return mainCount * DISCOUNT_PER_MAIN_PRICE;
    }
}
