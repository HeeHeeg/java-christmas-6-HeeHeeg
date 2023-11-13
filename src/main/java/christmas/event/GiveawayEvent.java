package christmas.event;

import christmas.calculation.Calculator;
import christmas.menu.Menu;
import christmas.menu.MenuItem;

import java.time.LocalDate;
import java.util.List;

public class GiveawayEvent {
    private static LocalDate EVENT_START_DATE = LocalDate.of(2023, 12, 1);
    private static LocalDate EVENT_END_DATE = LocalDate.of(2023, 12, 31);
    private static final Calculator calculator = new Calculator();

    public Menu checkGiveawayEvent(int date, List<MenuItem> menuItems) {
        LocalDate reservationDate = LocalDate.of(2023, 12, date);
        if (reservationDate.isBefore(EVENT_START_DATE)
                || reservationDate.isAfter(EVENT_END_DATE)) {
            return null;
        }
        if (calculator.calculateTotalPrice(menuItems) >= 120000) {
            return Menu.CHAMPAGNE;
        }
        return null;
    }
}
