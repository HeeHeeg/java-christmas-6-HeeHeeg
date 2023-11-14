package christmas.event;

import christmas.menu.Menu;
import christmas.menu.MenuItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BadgeAwarderTest {
    private BadgeAwarder badgeAwarder;

    @BeforeEach
    void setUp() {
        badgeAwarder = new BadgeAwarder();
    }

    @DisplayName("총혜택 금액이 20,000원 이상이면 산타 뱃지를 반환한다.")
    @Test
    void getSantaBadge() {
        //given
        int date = 3;
        List<MenuItem> orderedItems = List.of(
                new MenuItem(Menu.CAESAR_SALAD, 2),
                new MenuItem(Menu.T_BONE_STEAK, 2),
                new MenuItem(Menu.ICE_CREAM, 2),
                new MenuItem(Menu.RED_WINE, 2));
        //when
        Badge badge = badgeAwarder.getBadge(date, orderedItems);

        //then
        assertThat(badge).isEqualTo(Badge.SANTA);
    }

    @DisplayName("총혜택 금액이 10,000원 이상이면 트리 뱃지를 반환한다.")
    @Test
    void getTreeBadge() {
        //given
        int date = 3;
        List<MenuItem> orderedItems = List.of(new MenuItem(Menu.ICE_CREAM, 5));

        //when
        Badge badge = badgeAwarder.getBadge(date, orderedItems);

        //then
        assertThat(badge).isEqualTo(Badge.TREE);
    }

    @DisplayName("총혜택 금액이 5,000원 이상이면 별 뱃지를 반환한다.")
    @Test
    void getStarBadge() {
        //given
        int date = 3;
        List<MenuItem> orderedItems = List.of(new MenuItem(Menu.ICE_CREAM, 2));

        //when
        Badge badge = badgeAwarder.getBadge(date, orderedItems);

        //then
        assertThat(badge).isEqualTo(Badge.STAR);
    }
}