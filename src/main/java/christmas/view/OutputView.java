package christmas.view;

import christmas.menu.MenuItem;

import java.util.List;

public class OutputView {
    private static final InputView inputView = new InputView();

    public void printMenu(List<MenuItem> menuItems) {
        System.out.println("<주문 메뉴>");
        System.out.println();
        for (MenuItem menuItem : menuItems) {
            System.out.println(menuItem.getMenuName() + " " + menuItem.getQuantity() + "개");
        }
    }
}
