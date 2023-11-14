package christmas.event;

import christmas.calculation.Calculator;
import christmas.menu.Menu;
import christmas.menu.MenuItem;

import java.time.LocalDate;
import java.util.List;

import static christmas.event.EventManager.isWithinDecemberEventPeriod;

public class GiveawayEvent {
    private static final int EVENT_STANDARD_AMOUNT = 120000;
    private static final Calculator calculator = new Calculator();

    public Menu checkGiveawayEvent(int date, List<MenuItem> menuItems) {
        LocalDate reservationDate = LocalDate.of(2023, 12, date);
        if (!isWithinDecemberEventPeriod(reservationDate)) {
            return null;
        }
        if (calculator.totalPrice(menuItems) >= EVENT_STANDARD_AMOUNT) {
            return Menu.CHAMPAGNE;
        }
        return null;
    }
}
