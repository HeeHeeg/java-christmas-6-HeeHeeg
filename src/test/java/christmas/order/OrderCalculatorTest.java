package christmas.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderCalculatorTest {
    private OrderCalculator orderCalculator;

    @BeforeEach
    void setUp() {
        orderCalculator = new OrderCalculator();
    }

    @DisplayName("메뉴와 수량이 들어오면 총합계를 계산하여 반환한다.")
    @Test
    void calculatePriceReturn() {
        //given
        String menuName = "티본스테이크";
        int quantity = 2;

        //when
        int calculatedPrice = orderCalculator.calculatePrice(menuName, quantity);

        //then
        assertThat(calculatedPrice).isEqualTo(110000);
    }
}