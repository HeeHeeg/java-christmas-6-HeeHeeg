package christmas.event;

import christmas.calculation.Calculator;
import christmas.menu.MenuItem;

import java.util.List;

public class BadgeAwarder {
    private static final int MAXIMUM_STANDARD_AMOUNT = 20000;
    private static final int INTERMEDIATE_STANDARD_AMOUNT = 10000;
    private static final int MINIMUM_STANDARD_AMOUNT = 5000;

    private static final Calculator calculator = new Calculator();

    public Badge getBadge(int date, List<MenuItem> menuItems) {
        int totalBenefitAmount = calculator.totalBenefitAmount(date, menuItems);
        if (totalBenefitAmount >= MAXIMUM_STANDARD_AMOUNT) {
            return Badge.SANTA;
        }
        if (totalBenefitAmount >= INTERMEDIATE_STANDARD_AMOUNT) {
            return Badge.TREE;
        }
        if (totalBenefitAmount >= MINIMUM_STANDARD_AMOUNT) {
            return Badge.STAR;
        }
        return Badge.NONE;
    }
}
