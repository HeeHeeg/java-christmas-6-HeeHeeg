package christmas.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class MenuOrderParserTest {
    MenuOrderParser menuOrderParser;
    
    @BeforeEach
    void setUp() {
        menuOrderParser = new MenuOrderParser();
    }

    @DisplayName("메뉴판에 있는 메뉴면 true를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"양송이수프","해산물파스타", "초코케이크", "레드와인"})
    void checkMenuIsTrue(String menuName) {
        //when-then
        boolean validMenu = menuOrderParser.isValidMenu(menuName);
        assertThat(validMenu).isTrue();
    }

    @DisplayName("메뉴판에 있는 메뉴가 아니면 false를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"감자수프","해물파스타", "케이크", "화이트와인"})
    void checkMenuIsFalse(String menuName) {
        //when-then
        boolean validMenu = menuOrderParser.isValidMenu(menuName);
        assertThat(validMenu).isFalse();
    }
}