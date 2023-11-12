package christmas.menu;

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
}
