package christmas.view;

import christmas.calculation.Calculator;
import christmas.calculation.PriceFormatter;
import christmas.event.*;
import christmas.menu.MenuItem;

import java.util.List;

public class OutputView {
    private static final PriceFormatter priceFormatter = new PriceFormatter();
    private static final Calculator calculator = new Calculator();
    private static final GiveawayEvent giveaway = new GiveawayEvent();

    public void printMenu(List<MenuItem> menuItems) {
        System.out.println("12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
        System.out.println("<주문 메뉴>");
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
        System.out.println();
        System.out.println("<증정 메뉴>");
        System.out.println(giveaway.checkGiveawayEvent(date, menuItems).getName() + "1개");
    }

    public void benefitDetails(int date, List<MenuItem> menuItems) {
        System.out.println();
        System.out.println("<혜택 내역>");
        System.out.println("크리스마스 디데이 할인: -" + christmasBenefitAmount(date) + "원");
        System.out.println("평일 할인: -" + weekdayBenefitAmount(date, menuItems) + "원");
        System.out.println("특별 할인: -" + weekendBenefitAmount(date, menuItems) + "원");
        System.out.println("증정 이벤트: -" + giveawayBenefitAmount(date, menuItems) + "원");
    }

    private String christmasBenefitAmount(int date) {
        return priceFormatter.formatPrice(calculator.getChristmasBenefitAmount(date));
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
}
