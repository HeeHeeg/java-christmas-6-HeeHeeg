package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.menu.MenuItem;
import christmas.order.MenuOrderParser;
import christmas.validation.InputValidation;

import java.util.List;

public class InputView {
    private static final InputValidation inputValidation = new InputValidation();
    private static final MenuOrderParser menuOrderParser = new MenuOrderParser();

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

    public List<MenuItem> readMenu() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String inputMenu = Console.readLine();
        return menuOrderParser.parseOrder(inputMenu);
    }
}
