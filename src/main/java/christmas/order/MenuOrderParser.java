package christmas.order;

import christmas.menu.Menu;
import christmas.menu.MenuItem;
import christmas.validation.InputParser;
import christmas.validation.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class MenuOrderParser {
    private static final InputValidator inputValidator = new InputValidator();
    private static final InputParser inputParser = new InputParser();

    public List<MenuItem> parseOrder(String inputMenu) {
        String[] items = inputMenu.split(",");
        List<MenuItem> orderedMenuList = getOrderedMenuItems(items);
        inputValidator.checkOnlyBeveragesOrdered(orderedMenuList);
        inputValidator.checkOrderQuantity(orderedMenuList);
        return orderedMenuList;
    }

    private List<MenuItem> getOrderedMenuItems(String[] items) {
        List<MenuItem> orderedMenuList = new ArrayList<>();
        for (String menuItem : items) {
            String[] parts = getParts(menuItem);
            String menuName = getMenuName(parts);
            int quantity = getQuantity(parts);
            inputValidator.checkForDuplicateMenu(menuName, orderedMenuList);
            orderedMenuList.add(new MenuItem(Menu.getMenuByName(menuName).orElse(null), quantity));
        }
        return orderedMenuList;
    }

    private String[] getParts(String menuItem) {
        String[] parts = menuItem.split("-");
        inputValidator.checkMenuLength(parts);
        return parts;
    }

    private String getMenuName(String[] parts) {
        String menuName = parts[0].trim();
        inputValidator.checkMenuName(menuName);
        return menuName;
    }

    private int getQuantity(String[] parts) {
        int quantity = inputParser.menuQuantityParseNumber(parts[1].trim());
        inputValidator.menuQuantity(quantity);
        return quantity;
    }
}
