package christmas.validation;

import christmas.menu.MenuItem;

import java.util.List;

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
}
