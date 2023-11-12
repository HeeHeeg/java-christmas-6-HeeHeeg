package christmas.view;

import christmas.menu.MenuItem;
import christmas.order.OrderCalculator;

import java.util.List;

public class OutputView {
    private static final OrderCalculator orderCalculator = new OrderCalculator();

    public void printMenu(List<MenuItem> menuItems) {
        System.out.println("12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
        System.out.println("<주문 메뉴>");
        for (MenuItem menuItem : menuItems) {
            System.out.println(menuItem.getMenuName() + " " + menuItem.getQuantity() + "개");
        }
        System.out.println();
    }

    public void printTotalPrice(List<MenuItem> menuItems) {
        System.out.println("<할인 전 총주문 금액>");
        int totalPrice = 0;
        for (MenuItem menuItem : menuItems) {
            totalPrice += orderCalculator.calculatePrice(menuItem.getMenuName(), menuItem.getQuantity());
        }
        System.out.println(totalPrice + "원");
    }
}
