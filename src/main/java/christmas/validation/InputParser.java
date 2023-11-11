package christmas.validation;

public class InputParser {
    public int dateParseNumber(String input) {
        int inputNumber = 0;
        try {
            inputNumber = Integer.parseInt(input);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
        return inputNumber;
    }
    public int menuQuantityParseNumber(String input) {
        int menuQuantity = 0;
        try {
            menuQuantity = Integer.parseInt(input);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
        return menuQuantity;
    }
}
