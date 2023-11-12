package christmas.order;

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
        List<MenuItem> orderedMenuList = new ArrayList<>();
        for (String menuItem : items) {
            String[] parts = menuItem.split("-");
            inputValidator.checkMenuLength(parts);
            String menuName = parts[0].trim();
            inputValidator.checkMenuName(menuName);
            int quantity = inputParser.menuQuantityParseNumber(parts[1].trim());
            inputValidator.menuQuantity(quantity);
            inputValidator.checkForDuplicateMenu(menuName, orderedMenuList);
            orderedMenuList.add(new MenuItem(menuName, quantity));
        }
        inputValidator.checkOnlyBeveragesOrdered(orderedMenuList);
        return orderedMenuList;
    }
}
