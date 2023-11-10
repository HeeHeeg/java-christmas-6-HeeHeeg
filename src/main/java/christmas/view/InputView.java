package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.validation.InputValidation;

public class InputView {
    private static final InputValidation inputValidation = new InputValidation();

    public int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        boolean validInputNumber = false;
        int inputNumber = 0;
        while (!validInputNumber) {
            try {
                String input = Console.readLine();
                inputNumber = Integer.parseInt(input);
                inputValidation.days(inputNumber);
                validInputNumber = true;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
        }
        return inputNumber;
    }
}
