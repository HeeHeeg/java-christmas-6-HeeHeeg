package christmas.view;

import christmas.calculation.Calculator;
import christmas.calculation.PriceFormatter;
import christmas.event.*;
import christmas.menu.MenuItem;

import java.util.List;

import static christmas.event.EventManager.DISCOUNT_ZERO;

public class CheckBenefits {
    private static final GiveawayEvent giveaway = new GiveawayEvent();
    private static final PriceFormatter priceFormatter = new PriceFormatter();
    private static final Calculator calculator = new Calculator();
    private static final BadgeAwarder badgeAwarder = new BadgeAwarder();
    private static final ChristmasDiscountEvent christmasDiscountEvent = new ChristmasDiscountEvent();
    private static final WeekdayEvent weekdayEvent = new WeekdayEvent();
    private static final WeekendEvent weekendEvent = new WeekendEvent();
    private static final SpecialDiscountEvent specialDiscountEvent = new SpecialDiscountEvent();
    private static final GiveawayEvent giveawayEvent = new GiveawayEvent();

    public String giveawayMenu(int date, List<MenuItem> menuItems) {
        if (giveaway.checkGiveawayEvent(date, menuItems) == null) {
            return "없음";
        }
        return giveaway.checkGiveawayEvent(date, menuItems).getName() + " 1개";
    }

    public String allBenefits(int date, List<MenuItem> menuItems) {
        if ((christmasDiscountEvent.getChristmasBenefitAmount(date) == DISCOUNT_ZERO &&
                specialDiscountEvent.getSpecialBenefitAmount(date) == DISCOUNT_ZERO &&
                weekdayEvent.getWeekdayBenefitAmount(date, menuItems) == DISCOUNT_ZERO &&
                weekendEvent.getWeekendBenefitAmount(date, menuItems) == DISCOUNT_ZERO &&
                giveawayEvent.getGiveawayBenefitAmount(date, menuItems) == DISCOUNT_ZERO)) {
            return "없음";
        }
        return "";
    }

    public String christmas(int date) {
        if (christmasDiscountEvent.getChristmasBenefitAmount(date) == DISCOUNT_ZERO) {
            return "";
        }
        return "크리스마스 디데이 할인: -" + christmasDiscountEvent.christmasBenefitAmount(date) + "원";
    }

    public String special(int date) {
        if (specialDiscountEvent.getSpecialBenefitAmount(date) == DISCOUNT_ZERO) {
            return "";
        }
        return "특별 할인: -" + specialDiscountEvent.specialBenefitAmount(date) + "원";
    }

    public String weekday(int date, List<MenuItem> menuItems) {
        if (weekdayEvent.getWeekdayBenefitAmount(date, menuItems) == DISCOUNT_ZERO) {
            return "";
        }
        return "평일 할인: -" + weekdayEvent.weekdayBenefitAmount(date, menuItems) + "원";
    }

    public String weekend(int date, List<MenuItem> menuItems) {
        if (weekendEvent.getWeekendBenefitAmount(date, menuItems) == DISCOUNT_ZERO) {
            return "";
        }
        return "주말 할인: -" + weekendEvent.weekendBenefitAmount(date, menuItems) + "원";
    }

    public String giveaway(int date, List<MenuItem> menuItems) {
        if (giveawayEvent.getGiveawayBenefitAmount(date, menuItems) == DISCOUNT_ZERO) {
            return "";
        }
        return "증정 이벤트: -" + giveawayEvent.giveawayBenefitAmount(date, menuItems) + "원";
    }

    public String badge(int date, List<MenuItem> menuItems) {
        if (badgeAwarder.getBadge(date, menuItems) == Badge.NONE) {
            return Badge.NONE.getDisplayName();
        }
        return getBadge(date, menuItems).getDisplayName();
    }

    public String totalBenefitAmount(int date, List<MenuItem> menuItems) {
        if (calculator.totalBenefitAmount(date, menuItems) == DISCOUNT_ZERO) {
            return getTotalBenefitAmount(date, menuItems) + "원";

        }
        return "-" + getTotalBenefitAmount(date, menuItems) + "원";
    }

    private String getTotalBenefitAmount(int date, List<MenuItem> menuItems) {
        return priceFormatter.formatPrice(calculator.totalBenefitAmount(date, menuItems));
    }

    private Badge getBadge(int date, List<MenuItem> menuItems) {
        return badgeAwarder.getBadge(date, menuItems);
    }
}
