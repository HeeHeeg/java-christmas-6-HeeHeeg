package christmas.calculation;

import christmas.event.*;
import christmas.menu.Menu;
import christmas.menu.MenuItem;

import java.util.List;

public class Calculator {
    private static final ChristmasDiscountEvent christmasDiscountEvent = new ChristmasDiscountEvent();
    private static final WeekdayEvent weekdayEvent = new WeekdayEvent();
    private static final WeekendEvent weekendEvent = new WeekendEvent();
    private static final SpecialDiscountEvent specialDiscountEvent = new SpecialDiscountEvent();
    private static final GiveawayEvent giveawayEvent = new GiveawayEvent();
    public int totalPrice(List<MenuItem> menuItems) {
        int totalPrice = 0;
        for (MenuItem menuItem : menuItems) {
            totalPrice += menuItem.getMenu().calculatePrice(menuItem.getQuantity());
        }
        return totalPrice;
    }

    public int totalBenefitAmount(int date, List<MenuItem> menuItems) {
        int discountChristmasEventBenefitAmount = christmasDiscountEvent.checkChristmasDiscountPeriod(date);
        int discountWeekdayEventBenefitAmount = weekdayEvent.calculateDessertDiscount(menuItems, date);
        int discountWeekendEventBenefitAmount = weekendEvent.calculateMainDiscount(menuItems, date);
        int discountSpecialEventBenefitAmount = specialDiscountEvent.calculateSpecialDiscount(date);

        Menu giveawayItem = giveawayEvent.checkGiveawayEvent(date, menuItems);
        int discountGiveawayEventBenefitAmount = 0;
        if (giveawayItem != null) {
            discountGiveawayEventBenefitAmount = giveawayItem.getPrice();
        }

        int totalBenefitAmount = discountChristmasEventBenefitAmount
                + discountWeekdayEventBenefitAmount
                + discountWeekendEventBenefitAmount
                + discountSpecialEventBenefitAmount
                + discountGiveawayEventBenefitAmount;
        return totalBenefitAmount;
    }
}
