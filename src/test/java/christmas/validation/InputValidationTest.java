package christmas.validation;

import christmas.menu.Menu;
import christmas.menu.MenuItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidationTest {
    private InputValidator inputValidation;

    @BeforeEach
    void setUp() {
        inputValidation = new InputValidator();
    }

    @DisplayName("방문할 날짜가 1 이상 31 이하가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 32, -1})
    void dateOutOfRange(int reservationDate) {
        assertThatThrownBy(() -> inputValidation.date(reservationDate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @DisplayName("메뉴 수량이 1이상이 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void checkMenuQuantity(int quantity) {
        assertThatThrownBy(() -> inputValidation.menuQuantity(quantity))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("중복 메뉴를 입력하면 예외가 발생한다.")
    @Test
    void checkForDuplicateMenu() {
        List<MenuItem> orderedMenuList = new ArrayList<>();
        String menuName = "해산물파스타";
        int quantity = 1;
        orderedMenuList.add(new MenuItem(Menu.getMenuByName(menuName).orElse(null), quantity));

        assertThatThrownBy(() -> inputValidation.checkForDuplicateMenu(menuName, orderedMenuList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("메뉴판에 있는 메뉴면 true를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"양송이수프", "해산물파스타", "초코케이크", "레드와인"})
    void checkMenuIsTrue(String menuName) {
        //when-then
        boolean validMenu = inputValidation.isValidMenu(menuName);
        assertThat(validMenu).isTrue();
    }

    @DisplayName("메뉴판에 있는 메뉴가 아니면 false를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"감자수프", "해물파스타", "케이크", "화이트와인"})
    void checkMenuIsFalse(String menuName) {
        //when-then
        boolean validMenu = inputValidation.isValidMenu(menuName);
        assertThat(validMenu).isFalse();
    }

    @DisplayName("음료만 주문하면 예외가 발생한다.")
    @Test
    void checkOnlyBeveragesOrdered() {
        // given
        List<MenuItem> orderedMenuList = new ArrayList<>();
        String menuName1 = "제로콜라";
        String menuName2 = "레드와인";
        int quantity1 = 1;
        int quantity2 = 2;
        orderedMenuList.add(new MenuItem(Menu.getMenuByName(menuName1).orElse(null), quantity1));
        orderedMenuList.add(new MenuItem(Menu.getMenuByName(menuName2).orElse(null), quantity2));

        // when-then
        assertThatThrownBy(() -> inputValidation.checkOnlyBeveragesOrdered(orderedMenuList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 음료만 주문 시, 주문할 수 없습니다. 다시 입력해주세요.");
    }

    @DisplayName("메뉴를 한 번 20개를 초과하여 주문하면 예외가 발생한다.")
    @Test
    void checkOrderQuantity() {
        // given
        List<MenuItem> orderedMenuList = new ArrayList<>();
        String menuName1 = "해산물파스타";
        String menuName2 = "레드와인";
        int quantity1 = 11;
        int quantity2 = 10;
        orderedMenuList.add(new MenuItem(Menu.getMenuByName(menuName1).orElse(null), quantity1));
        orderedMenuList.add(new MenuItem(Menu.getMenuByName(menuName2).orElse(null), quantity2));

        // when-then
        assertThatThrownBy(() -> inputValidation.checkOrderQuantity(orderedMenuList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 메뉴는 한 번에 최대 20개 까지만 주문할 수 있습니다.");
    }
}