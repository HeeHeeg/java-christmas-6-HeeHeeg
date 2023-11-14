package christmas.calculation;

import christmas.menu.Menu;
import christmas.menu.MenuItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("메뉴를 받아서 총금액을 계산하여 반환 한다.")
    @Test
    void calculateTotalPrice() {
        //given
        List<MenuItem> orderedItems = List.of(
                new MenuItem(Menu.SEAFOOD_PASTA, 2),
                new MenuItem(Menu.ICE_CREAM, 2));

        //when
        int totalledPrice = calculator.totalPrice(orderedItems);

        //then
        assertThat(totalledPrice).isEqualTo(80000);
    }
}