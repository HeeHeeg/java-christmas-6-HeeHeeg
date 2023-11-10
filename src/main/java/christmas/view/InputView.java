package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        boolean validInputNumber = false;
        int inputNumber = 0;
        while (!validInputNumber) {
            String input = Console.readLine();
            inputNumber = Integer.parseInt(input);
            if (!(inputNumber >= 1 && inputNumber <= 31)) {
                validInputNumber = true;
            }
        }
        return inputNumber;
    }
}
