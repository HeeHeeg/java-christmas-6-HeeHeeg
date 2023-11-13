package christmas.menu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MenuTest {

    @DisplayName("메뉴의 수량을 받아서 주문한 메뉴의 총가격을 계산해 반환한다.")
    @Test
    void calculatePrice() {
        //given
        int quantity = 5;
        Menu menu = Menu.BBQ_RIBS;

        //when
        int totalPrice = menu.calculatePrice(quantity);

        //then
        assertThat(totalPrice).isEqualTo(270000);
    }

}