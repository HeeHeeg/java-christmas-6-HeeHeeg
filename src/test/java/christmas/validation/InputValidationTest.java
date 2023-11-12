package christmas.validation;

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
        orderedMenuList.add(new MenuItem(menuName, quantity));

        assertThatThrownBy(() -> inputValidation.checkForDuplicateMenu(menuName, orderedMenuList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("메뉴판에 있는 메뉴면 true를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"양송이수프","해산물파스타", "초코케이크", "레드와인"})
    void checkMenuIsTrue(String menuName) {
        //when-then
        boolean validMenu = inputValidation.isValidMenu(menuName);
        assertThat(validMenu).isTrue();
    }

    @DisplayName("메뉴판에 있는 메뉴가 아니면 false를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"감자수프","해물파스타", "케이크", "화이트와인"})
    void checkMenuIsFalse(String menuName) {
        //when-then
        boolean validMenu = inputValidation.isValidMenu(menuName);
        assertThat(validMenu).isFalse();
    }
}