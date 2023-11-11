package christmas.order;

import christmas.menu.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MenuOrderParser {

    public List<MenuItem> parseOrder(String inputMenu) {
        String[] items = inputMenu.split(",");
        List<MenuItem> orderedMenuList = new ArrayList<>();
        for (String menuItem : items) {
            String[] parts = menuItem.split("-");
            String menuName = parts[0].trim();
            int quantity = Integer.parseInt(parts[1].trim());
            orderedMenuList.add(new MenuItem(menuName, quantity));
        }
        return orderedMenuList;
    }
}
