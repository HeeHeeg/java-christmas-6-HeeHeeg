package christmas.event;

import christmas.menu.Menu;
import christmas.menu.MenuItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WeekdayEventTest {
    private WeekdayEvent weekdayEvent;

    @BeforeEach
    void setUp() {
        weekdayEvent = new WeekdayEvent();
    }

    @DisplayName("예약일이 금요일 또는 토요일(주말)이면 디저트 할인 금액 0원을 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 8, 9}) // 2023년 12월의 금요일과 토요일 날짜
    void reservationDateByNotWeekday(int date) {
        // given
        List<MenuItem> orderedItems = List.of(
                new MenuItem(Menu.SEAFOOD_PASTA, 1),
                new MenuItem(Menu.ICE_CREAM, 2));

        // when
        int discountedPrice = weekdayEvent.checkDessertDiscount(date, orderedItems);

        // then
        assertThat(discountedPrice).isEqualTo(0);
    }

    @DisplayName("예약일이 일요일~목요일(평일)이면 주문 메뉴에서 디저트 메뉴 1개당 2,023원씩 할인한 값을 계산해 할인금액을 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6, 7})  // 2023년 12월의 일요일~목요일 날짜
    void reservationDateWeekdaysDiscountPerDessert(int date) {
        // given
        List<MenuItem> orderedItems = List.of(
                new MenuItem(Menu.SEAFOOD_PASTA, 1),
                new MenuItem(Menu.ICE_CREAM, 2));

        // when
        int discountedPrice = weekdayEvent.checkDessertDiscount(date, orderedItems);

        // then
        assertThat(discountedPrice).isEqualTo(4046);
    }
}