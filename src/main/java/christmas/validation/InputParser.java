package christmas.validation;

public class InputParser {
    public int parseNumber(String input) {
        int inputNumber = 0;
        try {
            inputNumber = Integer.parseInt(input);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
        return inputNumber;
    }
}
