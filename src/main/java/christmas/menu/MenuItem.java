package christmas.menu;

import static christmas.menu.MenuCategory.DESSERT;
import static christmas.menu.MenuCategory.MAIN;

public class MenuItem {
    private static final int NO_QUANTITY = 0;
    private final Menu menu;
    private final int quantity;

    public MenuItem(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }

    public int countDessert() {
        if (menu.getCategory() == DESSERT) {
            return quantity;
        }
        return NO_QUANTITY;
    }

    public int countMain() {
        if (menu.getCategory() == MAIN) {
            return quantity;
        }
        return NO_QUANTITY;
    }
}
