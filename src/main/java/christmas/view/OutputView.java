package christmas.view;

import christmas.calculation.PriceFormatter;
import christmas.menu.MenuItem;

import java.util.List;

public class OutputView {
    private static final PriceFormatter priceFormatter = new PriceFormatter();
    public void printMenu(List<MenuItem> menuItems) {
        System.out.println("12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
        System.out.println("<주문 메뉴>");
        for (MenuItem menuItem : menuItems) {
            System.out.println(menuItem.getMenu() + " " + menuItem.getQuantity() + "개");
        }
        System.out.println();
    }

    public void printTotalPrice(int totalPrice) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(priceFormatter.formatPrice(totalPrice) + "원");
    }
}
