package christmas.validation;

import christmas.menu.Menu;
import christmas.menu.MenuCategory;
import christmas.menu.MenuItem;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class InputValidator {
    public void date(int reservationDate) {
        if (!(reservationDate >= 1 && reservationDate <= 31)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public void menuQuantity(int quantity) {
        if (!(quantity >= 1)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public void checkForDuplicateMenu(String menuName, List<MenuItem> orderedMenuList) {
        for (MenuItem menuItem : orderedMenuList) {
            if (menuItem.getMenuName().equalsIgnoreCase(menuName)) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }

    public void checkMenuLength(String[] parts) {
        if (parts.length != 2) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public void checkMenuName(String menuName) {
        if (!isValidMenu(menuName)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public boolean isValidMenu(String menuName) {
        return Arrays.stream(Menu.values())
                .anyMatch(menu -> menu.getName().equalsIgnoreCase(menuName));
    }

    public void checkOnlyBeveragesOrdered(List<MenuItem> orderedMenuList) {
        for (MenuItem menuItem : orderedMenuList) {
            Optional<Menu> menu = Menu.getMenuByName(menuItem.getMenuName());
            if (menu.isPresent() && menu.get().getCategory() != MenuCategory.BEVERAGE) {
                return;
            }
        }
        throw new IllegalArgumentException("[ERROR] 음료만 주문 시, 주문할 수 없습니다. 다시 입력해주세요.");
    }
}
