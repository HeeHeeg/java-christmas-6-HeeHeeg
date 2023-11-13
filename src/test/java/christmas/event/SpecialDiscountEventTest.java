package christmas.event;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class SpecialDiscountEventTest {
    private SpecialDiscountEvent specialDiscountEvent;

    @BeforeEach
    void setUp() {
        specialDiscountEvent = new SpecialDiscountEvent();
    }

    @DisplayName("별 표시된 날 주문 시 할인금 1000원을 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 10, 17, 24, 25, 31})
    void calculateSpecialDiscount(int date) {
        // when
        int discountedPrice = specialDiscountEvent.calculateSpecialDiscount(date);

        // then
        assertThat(discountedPrice).isEqualTo(1000);
    }
}