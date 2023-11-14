package christmas.view;

import christmas.calculation.Calculator;
import christmas.calculation.PriceFormatter;
import christmas.menu.MenuItem;

import java.util.List;

public class OutputView {
    private static final CheckBenefits checkBenefits = new CheckBenefits();
    private static final PriceFormatter priceFormatter = new PriceFormatter();
    private static final Calculator calculator = new Calculator();

    public void printMenu(List<MenuItem> menuItems) {
        System.out.println("12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println("\n<주문 메뉴>");
        for (MenuItem menuItem : menuItems) {
            System.out.println(menuItem.getMenu().getName() + " " + menuItem.getQuantity() + "개");
        }
        System.out.println();
    }

    public void printTotalPrice(int totalPrice) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(priceFormatter.formatPrice(totalPrice) + "원");
    }

    public void printGiveawayMenu(int date, List<MenuItem> menuItems) {
        System.out.println("\n<증정 메뉴>");
        System.out.println(checkBenefits.giveawayMenu(date, menuItems));
    }

    public void benefitDetails(int date, List<MenuItem> menuItems) {
        System.out.println("\n<혜택 내역>");
        String christmasDetail = checkBenefits.christmas(date);
        if (!christmasDetail.isEmpty()) {
            System.out.println(christmasDetail);
        }
        String specialDetail = checkBenefits.special(date);
        if (!specialDetail.isEmpty()) {
            System.out.println(specialDetail);
        }
        String weekdayDetail = checkBenefits.weekday(date, menuItems);
        if (!weekdayDetail.isEmpty()) {
            System.out.println(weekdayDetail);
        }
        String weekendDetail = checkBenefits.weekend(date, menuItems);
        if (!weekendDetail.isEmpty()) {
            System.out.println(weekendDetail);
        }
        String giveawayDetail = checkBenefits.giveaway(date, menuItems);
        if (!giveawayDetail.isEmpty()) {
            System.out.println(giveawayDetail);
        }
        String allBenefitsDetail = checkBenefits.allBenefits(date, menuItems);
        if (!allBenefitsDetail.isEmpty()) {
            System.out.println(allBenefitsDetail);
        }
    }

    public void totalBenefitAmount(int date, List<MenuItem> menuItems) {
        System.out.println("\n<총혜택 금액>");
        System.out.println(checkBenefits.totalBenefitAmount(date, menuItems));
    }

    public void totalPaymentAmount(int date, List<MenuItem> menuItems) {
        System.out.println("\n<할인 후 예상 결제 금액>");
        System.out.println(expectedPaymentAmount(date, menuItems));
    }

    public void earnedBadges(int date, List<MenuItem> menuItems) {
        System.out.println("\n<12월 이벤트 배지>");
        System.out.println(checkBenefits.badge(date, menuItems));
    }

    private String expectedPaymentAmount(int date, List<MenuItem> menuItems) {
        return priceFormatter.formatPrice(calculator.expectedPaymentAmount(date, menuItems));
    }
}
