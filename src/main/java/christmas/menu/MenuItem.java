package christmas.menu;

public class MenuItem {
    private final String menuName;
    private final int quantity;

    public MenuItem(String menuName, int quantity) {
        this.menuName = menuName;
        this.quantity = quantity;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getQuantity() {
        return quantity;
    }
}
