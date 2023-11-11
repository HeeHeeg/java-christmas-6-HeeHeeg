package christmas.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidationTest {
    private InputValidator inputValidation;
    private InputParser inputParser;

    @BeforeEach
    void setUp() {
        inputValidation = new InputValidator();
        inputParser = new InputParser();
    }

    @DisplayName("방문할 날짜가 1 이상 31 이하가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 32, -1})
    void dateOutOfRange(int reservationDate) {
        assertThatThrownBy(() -> inputValidation.date(reservationDate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @DisplayName("방문할 날짜가 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"숫자가아닌 값", "1j", " "})
    void visitDateIsNotNumber(String input) {
        assertThatThrownBy(() -> inputParser.dateParseNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @DisplayName("메뉴 수량이 1이상이 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void checkMenuQuantity(int quantity) {
        assertThatThrownBy(() -> inputValidation.menuQuantity(quantity))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("메뉴 수량에 숫자가 아닌 값이 들어오면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"숫자가아닌 값", "1j", " "})
    void checkMenuQuantityNotNumber(String input) {
        assertThatThrownBy(() -> inputParser.dateParseNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }
}