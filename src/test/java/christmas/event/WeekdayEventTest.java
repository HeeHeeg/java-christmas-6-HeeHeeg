package christmas.event;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class WeekdayEventTest {
    private WeekdayEvent weekdayEvent;

    @BeforeEach
    void setUp() {
        weekdayEvent = new WeekdayEvent();
    }

    @DisplayName("예약일이 금요일 또는 토요일(주말)이면 false를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 8, 9}) // 2023년 12월의 금요일과 토요일 날짜
    void reservationDateByNotWeekday(int date) {
        // when
        boolean checkWeekday = weekdayEvent.checkWeekdayDiscountPeriod(date);

        // then
        assertThat(checkWeekday).isFalse();
    }

    @DisplayName("예약일이 일요일~목요일(평일)이면 true를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6, 7}) // 2023년 12월의 일요일~목요일 날짜
    void reservationDateWeekdays(int date) {
        // when
        boolean checkWeekday = weekdayEvent.checkWeekdayDiscountPeriod(date);

        // then
        assertThat(checkWeekday).isTrue();
    }
}