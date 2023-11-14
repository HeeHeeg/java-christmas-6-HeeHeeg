package christmas.view;

import christmas.calculation.Calculator;
import christmas.calculation.PriceFormatter;
import christmas.event.Badge;
import christmas.event.BadgeAwarder;
import christmas.event.GiveawayEvent;
import christmas.menu.MenuItem;

import java.util.List;

import static christmas.event.EventManager.DISCOUNT_ZERO;

public class CheckBenefits {
    private static final GiveawayEvent giveaway = new GiveawayEvent();
    private static final PriceFormatter priceFormatter = new PriceFormatter();
    private static final Calculator calculator = new Calculator();
    private static final BadgeAwarder badgeAwarder = new BadgeAwarder();

    public String giveawayMenu(int date, List<MenuItem> menuItems) {
        if (giveaway.checkGiveawayEvent(date, menuItems) == null) {
            return "없음";
        }
        return giveaway.checkGiveawayEvent(date, menuItems).getName() + "1개";
    }

    public String allBenefits(int date, List<MenuItem> menuItems) {
        if ((calculator.getChristmasBenefitAmount(date) == DISCOUNT_ZERO &&
                calculator.getSpecialBenefitAmount(date) == DISCOUNT_ZERO &&
                calculator.getWeekdayBenefitAmount(date, menuItems) == DISCOUNT_ZERO &&
                calculator.getWeekendBenefitAmount(date, menuItems) == DISCOUNT_ZERO &&
                calculator.getGiveawayBenefitAmount(date, menuItems) == DISCOUNT_ZERO)) {
            return "없음";
        }
        return "";
    }

    public String christmas(int date) {
        if (calculator.getChristmasBenefitAmount(date) == DISCOUNT_ZERO) {
            return "";
        }
        return "크리스마스 디데이 할인: -" + christmasBenefitAmount(date) + "원";
    }

    public String special(int date) {
        if (calculator.getSpecialBenefitAmount(date) == DISCOUNT_ZERO) {
            return "";
        }
        return "특별 할인: -" + specialBenefitAmount(date) + "원";
    }

    public String weekday(int date, List<MenuItem> menuItems) {
        if (calculator.getWeekdayBenefitAmount(date, menuItems) == DISCOUNT_ZERO) {
            return "";
        }
        return "평일 할인: -" + weekdayBenefitAmount(date, menuItems) + "원";
    }

    public String weekend(int date, List<MenuItem> menuItems) {
        if (calculator.getWeekendBenefitAmount(date, menuItems) == DISCOUNT_ZERO) {
            return "";
        }
        return "주말 할인: -" + weekendBenefitAmount(date, menuItems) + "원";
    }

    public String giveaway(int date, List<MenuItem> menuItems) {
        if (calculator.getGiveawayBenefitAmount(date, menuItems) == DISCOUNT_ZERO) {
            return "";
        }
        return "증정 이벤트: -" + giveawayBenefitAmount(date, menuItems) + "원";
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

    private String christmasBenefitAmount(int date) {
        return priceFormatter.formatPrice(calculator.getChristmasBenefitAmount(date));
    }

    private String specialBenefitAmount(int date) {
        return priceFormatter.formatPrice(calculator.getSpecialBenefitAmount(date));
    }

    private String weekdayBenefitAmount(int date, List<MenuItem> menuItems) {
        return priceFormatter.formatPrice(calculator.getWeekdayBenefitAmount(date, menuItems));
    }

    private String weekendBenefitAmount(int date, List<MenuItem> menuItems) {
        return priceFormatter.formatPrice(calculator.getWeekendBenefitAmount(date, menuItems));
    }

    private String giveawayBenefitAmount(int date, List<MenuItem> menuItems) {
        return priceFormatter.formatPrice(calculator.getGiveawayBenefitAmount(date, menuItems));
    }

    private Badge getBadge(int date, List<MenuItem> menuItems) {
        return badgeAwarder.getBadge(date, menuItems);
    }
}
