package christmas.view;

import christmas.event.GiveawayEvent;
import christmas.menu.MenuItem;

import java.util.List;

public class CheckBenefits {
    private static final GiveawayEvent giveaway = new GiveawayEvent();

    public String checkGiveaway(int date, List<MenuItem> menuItems) {
        if (giveaway.checkGiveawayEvent(date, menuItems) == null) {
            return "없음";
        }
        return giveaway.checkGiveawayEvent(date, menuItems).getName() + "1개";
    }

}
