package christmas.order;

import christmas.menu.MenuItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MenuOrderParserTest {
    MenuOrderParser menuOrderParser;

    @BeforeEach
    void setUp() {
        menuOrderParser = new MenuOrderParser();
    }

    @DisplayName("메뉴는 ','와 '-'를 기준으로 분리해서 리스트에 담는다.")
    @Test
    void splitInputMenu() {
        // given
        String inputMenu = "해산물파스타-18,레드와인-1,초코케이크-1";

        // when
        List<MenuItem> menuItems = menuOrderParser.parseOrder(inputMenu);

        // then
        assertThat(menuItems.get(0).getMenu().getName()).isEqualTo("해산물파스타");
        assertThat(menuItems.get(1).getMenu().getName()).isEqualTo("레드와인");
        assertThat(menuItems.get(2).getMenu().getName()).isEqualTo("초코케이크");
        assertThat(menuItems.get(0).getQuantity()).isEqualTo(18);
        assertThat(menuItems.get(1).getQuantity()).isEqualTo(1);
        assertThat(menuItems.get(2).getQuantity()).isEqualTo(1);
    }

    @DisplayName("메뉴 수량이 1이상이 아니면 예외가 발생한다.")
    @Test
    void parseOrderByCheckMenuQuantity() {
        // given
        String inputMenu = "해산물파스타-0,레드와인-1,초코케이크-1";

        // when-then
        assertThatThrownBy(() -> menuOrderParser.parseOrder(inputMenu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("메뉴 수량에 숫자가 아닌 값이 들어오면 예외가 발생한다.")
    @Test
    void parseOrderByCheckMenuQuantityNotNumber() {
        // given
        String inputMenu = "해산물파스타-abc,레드와인-1,초코케이크-1";

        // when-then
        assertThatThrownBy(() -> menuOrderParser.parseOrder(inputMenu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("중복 메뉴를 입력하면 예외가 발생한다.")
    @Test
    void parseOrderByCheckForDuplicateMenu() {
        // given
        String inputMenu = "해산물파스타-1,해산물파스타-1,초코케이크-1";

        // when-then
        assertThatThrownBy(() -> menuOrderParser.parseOrder(inputMenu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("메뉴판에 있는 메뉴가 아니면 예외가 발생한다")
    @Test
    void parseOrderByCheckMenuIsFalse() {
        // given
        String inputMenu = "감자스프-1,해물파스타-1,케이크-1";

        // when-then
        assertThatThrownBy(() -> menuOrderParser.parseOrder(inputMenu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("음료만 주문하면 예외가 발생한다.")
    @Test
    void parseOrderByCheckOnlyBeveragesOrdered() {
        // given
        String inputMenu = "레드와인-1,제로콜라-1,샴페인-1";

        // when-then
        assertThatThrownBy(() -> menuOrderParser.parseOrder(inputMenu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 음료만 주문 시, 주문할 수 없습니다. 다시 입력해주세요.");
    }

    @DisplayName("메뉴를 한 번 20개를 초과하여 주문하면 예외가 발생한다.")
    @Test
    void parseOrderByCheckOrderQuantity() {
        // given
        String inputMenu = "해산물파스타-11,제로콜라-6,초코케이크-4";

        // when-then
        assertThatThrownBy(() -> menuOrderParser.parseOrder(inputMenu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 메뉴는 한 번에 최대 20개 까지만 주문할 수 있습니다.");
    }
}