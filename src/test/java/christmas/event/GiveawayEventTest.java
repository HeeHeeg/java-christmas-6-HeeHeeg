package christmas.event;

import christmas.menu.Menu;
import christmas.menu.MenuItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static christmas.menu.Menu.*;
import static org.assertj.core.api.Assertions.assertThat;

class GiveawayEventTest {
    private GiveawayEvent giveawayEvent;

    @BeforeEach
    void setUp() {
        giveawayEvent = new GiveawayEvent();
    }

    @DisplayName("할인전 총주문 금액이 120,000원이 넘으면 증정품 샴페인을 반환한다.")
    @Test
    void checkGiveawayEvent() {
        //given
        int date = 3;
        List<MenuItem> orderedItems = List.of(
                new MenuItem(T_BONE_STEAK, 2),
                new MenuItem(ICE_CREAM, 2));
        //when
        Menu giveawayMenu = giveawayEvent.checkGiveawayEvent(date, orderedItems);

        //then
        assertThat(giveawayMenu).isEqualTo(CHAMPAGNE);
    }

    @DisplayName("할인 전 총주문 금액이 120,000원이 넘지 않으면 null을 반환한다.")
    @Test
    void checkGiveawayEventNull() {
        //given
        int date = 3;
        List<MenuItem> orderedItems = List.of(
                new MenuItem(T_BONE_STEAK, 2),
                new MenuItem(ICE_CREAM, 1));
        //when
        Menu giveawayMenu = giveawayEvent.checkGiveawayEvent(date, orderedItems);

        //then
        assertThat(giveawayMenu).isEqualTo(null);
    }
}