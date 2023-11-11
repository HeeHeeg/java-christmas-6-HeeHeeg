package christmas.order;

import christmas.menu.Menu;

public class OrderCalculator {
    public int calculatePrice(String menuName, int quantity) {
        return Menu.getMenuByName(menuName)
                .map(menu -> menu.getPrice() * quantity)
                .orElse(0);
    }
}
