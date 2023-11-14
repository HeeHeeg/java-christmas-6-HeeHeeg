package christmas.calculation;

import christmas.event.*;
import christmas.menu.Menu;
import christmas.menu.MenuItem;

import java.util.List;

import static christmas.event.EventManager.DISCOUNT_ZERO;

public class Calculator {
    private static final int MINIMUM_ORDER_AMOUNT = 10000;
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
        if (totalPrice(menuItems) < MINIMUM_ORDER_AMOUNT) {
            return DISCOUNT_ZERO;
        }
        return getTotalBenefitAmount(date, menuItems);
    }

    private int getTotalBenefitAmount(int date, List<MenuItem> menuItems) {
        int christmasBenefitAmount = christmasDiscountEvent.checkChristmasDiscountPeriod(date);
        int weekdayBenefitAmount = weekdayEvent.calculateDessertDiscount(menuItems, date);
        int weekendBenefitAmount = weekendEvent.calculateMainDiscount(menuItems, date);
        int specialBenefitAmount = specialDiscountEvent.calculateSpecialDiscount(date);
        int giveawayBenefitAmount = getGiveawayBenefitAmount(date, menuItems);

        int totalBenefitAmount = getTotalBenefitAmount(
                christmasBenefitAmount,
                weekdayBenefitAmount,
                weekendBenefitAmount,
                specialBenefitAmount,
                giveawayBenefitAmount);
        return totalBenefitAmount;
    }

    private int getGiveawayBenefitAmount(int date, List<MenuItem> menuItems) {
        Menu giveawayItem = giveawayEvent.checkGiveawayEvent(date, menuItems);
        int giveawayBenefitAmount = 0;
        if (giveawayItem != null) {
            giveawayBenefitAmount = giveawayItem.getPrice();
        }
        return giveawayBenefitAmount;
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

    public int expectedPaymentAmount(int date, List<MenuItem> menuItems) {
        return totalPrice(menuItems) - totalBenefitAmount(date, menuItems);
    }
}
