package christmas.calculation;

import christmas.event.*;
import christmas.menu.MenuItem;

import java.util.List;

import static christmas.event.EventManager.DISCOUNT_ZERO;

public class Calculator {
    public static final int MINIMUM_ORDER_AMOUNT = 10000;
    private final ChristmasDiscountEvent christmasDiscountEvent;
    private final WeekdayEvent weekdayEvent;
    private final WeekendEvent weekendEvent;
    private final SpecialDiscountEvent specialDiscountEvent;
    private final GiveawayEvent giveawayEvent;

    public Calculator() {
        this.christmasDiscountEvent = new ChristmasDiscountEvent();
        this.weekdayEvent = new WeekdayEvent();
        this.weekendEvent = new WeekendEvent();
        this.specialDiscountEvent = new SpecialDiscountEvent();
        this.giveawayEvent = new GiveawayEvent();
    }

    public int totalPrice(List<MenuItem> menuItems) {
        int totalPrice = 0;
        for (MenuItem menuItem : menuItems) {
            totalPrice += menuItem.getMenu().calculatePrice(menuItem.getQuantity());
        }
        return totalPrice;
    }

    public int finalDiscountAmount(int date, List<MenuItem> menuItems) {
        int giveawayBenefitAmount = giveawayEvent.getGiveawayBenefitAmount(date, menuItems);
        return totalBenefitAmount(date, menuItems) - giveawayBenefitAmount;

    }

    public int totalBenefitAmount(int date, List<MenuItem> menuItems) {
        if (totalPrice(menuItems) < MINIMUM_ORDER_AMOUNT) {
            return DISCOUNT_ZERO;
        }
        int christmasBenefitAmount = christmasDiscountEvent.checkChristmasDiscountPeriod(date);
        int weekdayBenefitAmount = weekdayEvent.checkDessertDiscount(date, menuItems);
        int weekendBenefitAmount = weekendEvent.checkMainDiscount(date, menuItems);
        int specialBenefitAmount = specialDiscountEvent.checkSpecialDiscount(date);
        int giveawayBenefitAmount = giveawayEvent.getGiveawayBenefitAmount(date, menuItems);

        return christmasBenefitAmount + weekdayBenefitAmount
                + weekendBenefitAmount + specialBenefitAmount + giveawayBenefitAmount;
    }

    public int expectedPaymentAmount(int date, List<MenuItem> menuItems) {
        return totalPrice(menuItems) - finalDiscountAmount(date, menuItems);
    }
}
