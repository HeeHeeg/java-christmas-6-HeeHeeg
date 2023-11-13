package christmas.calculation;

import christmas.menu.MenuItem;

import java.util.List;

public class Calculator {
    public int calculateTotalPrice(List<MenuItem> menuItems) {
        int totalPrice = 0;
        for (MenuItem menuItem : menuItems) {
            totalPrice += menuItem.getMenu().calculatePrice(menuItem.getQuantity());
        }
        return totalPrice;
    }
}
