package christmas.event;

import christmas.calculation.Calculator;
import christmas.calculation.PriceFormatter;
import christmas.menu.Menu;
import christmas.menu.MenuItem;

import java.time.LocalDate;
import java.util.List;

import static christmas.event.EventManager.isWithinDecemberEventPeriod;

public class GiveawayEvent {
    private static final int EVENT_STANDARD_AMOUNT = 120000;
    private static final Calculator calculator = new Calculator();
    private static final PriceFormatter priceFormatter = new PriceFormatter();

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

    public int getGiveawayBenefitAmount(int date, List<MenuItem> menuItems) {
        Menu giveawayItem = checkGiveawayEvent(date, menuItems);
        int giveawayBenefitAmount = 0;
        if (giveawayItem != null) {
            giveawayBenefitAmount = giveawayItem.getPrice();
        }
        return giveawayBenefitAmount;
    }

    public String giveawayBenefitAmount(int date, List<MenuItem> menuItems) {
        return priceFormatter.formatPrice(getGiveawayBenefitAmount(date, menuItems));
    }
}
