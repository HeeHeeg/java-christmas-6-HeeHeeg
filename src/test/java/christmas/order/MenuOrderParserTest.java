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
        String inputMenu = "해산물파스타-2,레드와인-1,초코케이크-1";

        // when
        List<MenuItem> menuItems = menuOrderParser.parseOrder(inputMenu);

        // then
        assertThat(menuItems.get(0).getMenuName()).isEqualTo("해산물파스타");
        assertThat(menuItems.get(1).getMenuName()).isEqualTo("레드와인");
        assertThat(menuItems.get(2).getMenuName()).isEqualTo("초코케이크");
        assertThat(menuItems.get(0).getQuantity()).isEqualTo(2);
        assertThat(menuItems.get(1).getQuantity()).isEqualTo(1);
        assertThat(menuItems.get(2).getQuantity()).isEqualTo(1);
    }

    @DisplayName("메뉴 수량이 1이상이 아니면 예외가 발생한다.")
    @Test
    void checkMenuQuantity() {
        // given
        String inputMenu = "해산물파스타-0,레드와인-1,초코케이크-1";

        // when-then
        assertThatThrownBy(() ->  menuOrderParser.parseOrder(inputMenu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("메뉴 수량에 숫자가 아닌 값이 들어오면 예외가 발생한다.")
    @Test
    void checkMenuQuantityNotNumber() {
        // given
        String inputMenu = "해산물파스타-abc,레드와인-1,초코케이크-1";

        // when-then
        assertThatThrownBy(() ->  menuOrderParser.parseOrder(inputMenu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("중복 메뉴를 입력하면 예외가 발생한다.")
    @Test
    void checkForDuplicateMenu() {
        // given
        String inputMenu = "해산물파스타-1,해산물파스타-1,초코케이크-1";

        // when-then
        assertThatThrownBy(() ->  menuOrderParser.parseOrder(inputMenu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}