package christmas.event;

import christmas.calculation.PriceFormatter;
import christmas.menu.MenuItem;

import java.time.LocalDate;
import java.util.List;

import static christmas.event.EventManager.DISCOUNT_ZERO;
import static christmas.event.EventManager.isWithinDecemberEventPeriod;

public class WeekdayEvent {
    private static final int DISCOUNT_PER_DESSERT_PRICE = 2023;
    private static final EventManager eventManager = new EventManager();
    private static final PriceFormatter priceFormatter = new PriceFormatter();

    public int checkDessertDiscount(int date, List<MenuItem> orderedItems) {
        LocalDate reservationDate = LocalDate.of(2023, 12, date);
        if ((isWithinDecemberEventPeriod(reservationDate) && !eventManager.isWeekend(reservationDate))) {
            return calculateWeekdayDiscount(orderedItems);
        }
        return DISCOUNT_ZERO;
    }

    private int calculateWeekdayDiscount(List<MenuItem> orderedItems) {
        int dessertCount = 0;

        for (MenuItem orderedItem : orderedItems) {
            dessertCount += orderedItem.countDessert();
        }
        return dessertCount * DISCOUNT_PER_DESSERT_PRICE;
    }

    public String weekdayBenefitAmount(int date, List<MenuItem> menuItems) {
        return priceFormatter.formatPrice(checkDessertDiscount(date, menuItems));
    }
}