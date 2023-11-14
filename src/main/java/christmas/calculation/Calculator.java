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
        int christmasBenefitAmount = christmasDiscountEvent.checkChristmasDiscountPeriod(date);
        int weekdayBenefitAmount = weekdayEvent.calculateDessertDiscount(menuItems, date);
        int weekendBenefitAmount = weekendEvent.calculateMainDiscount(menuItems, date);
        int specialBenefitAmount = specialDiscountEvent.calculateSpecialDiscount(date);

        Menu giveawayItem = giveawayEvent.checkGiveawayEvent(date, menuItems);
        int giveawayBenefitAmount = 0;
        if (giveawayItem != null) {
            giveawayBenefitAmount = giveawayItem.getPrice();
        }

        int totalBenefitAmount = getTotalBenefitAmount(
                christmasBenefitAmount,
                weekdayBenefitAmount,
                weekendBenefitAmount,
                specialBenefitAmount,
                giveawayBenefitAmount);
        return totalBenefitAmount;
    }

    private int getTotalBenefitAmount(
            int christmasBenefitAmount, int weekdayBenefitAmount, int weekendBenefitAmount,
            int specialBenefitAmount, int giveawayBenefitAmount) {

        int totalBenefitAmount =
                christmasBenefitAmount
                + weekdayBenefitAmount
                + weekendBenefitAmount
                + specialBenefitAmount
                + giveawayBenefitAmount;
        return totalBenefitAmount;
    }
}
