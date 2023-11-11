package christmas.order;

import christmas.menu.MenuItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
}