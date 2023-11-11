package christmas.order;

import christmas.menu.Menu;
import christmas.menu.MenuItem;
import christmas.validation.InputParser;
import christmas.validation.InputValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuOrderParser {
    private static final InputValidator inputValidation = new InputValidator();
    private static final InputParser inputParser = new InputParser();

    public List<MenuItem> parseOrder(String inputMenu) {
        String[] items = inputMenu.split(",");
        List<MenuItem> orderedMenuList = new ArrayList<>();
        for (String menuItem : items) {
            String[] parts = menuItem.split("-");
            String menuName = parts[0].trim();
            if (!isValidMenu(menuName)) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
            int quantity = inputParser.menuQuantityParseNumber(parts[1].trim());
            inputValidation.menuQuantity(quantity);
            orderedMenuList.add(new MenuItem(menuName, quantity));
        }
        return orderedMenuList;
    }

    public boolean isValidMenu(String menuName) {
        return Arrays.stream(Menu.values())
                .anyMatch(menu -> menu.getName().equalsIgnoreCase(menuName));
    }
}
