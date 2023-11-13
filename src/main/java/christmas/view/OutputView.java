package christmas.view;

import christmas.menu.MenuItem;

import java.util.List;

public class OutputView {
    public void printMenu(List<MenuItem> menuItems) {
        System.out.println("12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
        System.out.println("<주문 메뉴>");
        for (MenuItem menuItem : menuItems) {
            System.out.println(menuItem.getMenu() + " " + menuItem.getQuantity() + "개");
        }
        System.out.println();
    }

    public int printTotalPrice(List<MenuItem> menuItems) {
        System.out.println("<할인 전 총주문 금액>");
        int totalPrice = 0;
        for (MenuItem menuItem : menuItems) {
            totalPrice += menuItem.getMenu().calculatePrice(menuItem.getQuantity());
        }
        System.out.println(totalPrice + "원");
        return totalPrice;
    }
}
