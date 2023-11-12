package christmas.event;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ChristmasDiscountEventTest {
    private ChristmasDiscountEvent christmasDiscountEvent;

    @BeforeEach
    void setUp() {
        christmasDiscountEvent = new ChristmasDiscountEvent();
    }

    @DisplayName("예약일이 크리스마스 할인 이벤트 기간이 아니면 할인금액 0원을 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {26, 27, 28, 29, 30, 31})
    void reservationDateByNotChristmasDiscountEventPeriod(int date) {
        // when-then
        int calculatedDiscount = christmasDiscountEvent.calculateDiscount(date);
        assertThat(calculatedDiscount).isEqualTo(0);
    }
}