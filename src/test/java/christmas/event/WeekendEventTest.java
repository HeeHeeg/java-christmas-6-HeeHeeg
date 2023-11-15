package christmas.event;

import christmas.menu.MenuItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static christmas.menu.Menu.*;
import static org.assertj.core.api.Assertions.assertThat;

class WeekendEventTest {
    private WeekendEvent weekendEvent;

    @BeforeEach
    void setUp() {
        weekendEvent = new WeekendEvent();
    }

    @DisplayName("예약일이 일요일~목요일(평일)이면 메인 메뉴 할인 금액 0원을 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6, 7, 25}) // 2023년 12월의 일요일~목요일 날짜
    void reservationDateByNotWeekday(int date) {
        // given
        List<MenuItem> orderedItems = List.of(
                new MenuItem(SEAFOOD_PASTA, 1),
                new MenuItem(ICE_CREAM, 2));

        // when
        int discountedPrice = weekendEvent.checkMainDiscount(date, orderedItems);

        // then
        assertThat(discountedPrice).isEqualTo(0);
    }

    @DisplayName("예약일이 금요일 또는 토요일(주말)이면 주문 메뉴에서 메인 메뉴 1개당 2,023원씩 할인한 값을 계산해 할인금액을 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 8, 9}) // 2023년 12월의 금요일과 토요일 날짜
    void reservationDateWeekdaysDiscountPerDessert(int date) {
        // given
        List<MenuItem> orderedItems = List.of(
                new MenuItem(SEAFOOD_PASTA, 1),
                new MenuItem(T_BONE_STEAK, 2),
                new MenuItem(ICE_CREAM, 2));

        // when
        int discountedPrice = weekendEvent.checkMainDiscount(date, orderedItems);

        // then
        assertThat(discountedPrice).isEqualTo(6069);
    }
}