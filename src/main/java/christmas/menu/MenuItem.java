package christmas.menu;

import static christmas.menu.MenuCategory.DESSERT;

public class MenuItem {
    private final Menu menu;
    private final int quantity;
    private static final int NO_QUANTITY = 0;

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
}
