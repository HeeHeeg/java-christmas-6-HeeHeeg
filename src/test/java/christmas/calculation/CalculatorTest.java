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

    @DisplayName("날짜와 메뉴를 받아서 총혜택 금액을 반환한다.")
    @Test
    void calculateTotalBenefitAmount() {
        //given
        int date = 25;
        List<MenuItem> orderedItems = List.of(
                new MenuItem(Menu.CAESAR_SALAD, 2),
                new MenuItem(Menu.T_BONE_STEAK, 2),
                new MenuItem(Menu.ICE_CREAM, 2),
                new MenuItem(Menu.RED_WINE, 2));

        //when
        int totalledPrice = calculator.totalBenefitAmount(date, orderedItems);

        //then
        int expectedTotalBenefitAmount = 33446;
        assertThat(totalledPrice).isEqualTo(expectedTotalBenefitAmount);
    }
}