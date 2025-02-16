package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.menu.MenuItem;
import christmas.order.MenuOrderParser;
import christmas.validation.InputParser;
import christmas.validation.InputValidator;

import java.util.List;

public class InputView {
    private static final InputValidator inputValidation = new InputValidator();
    private static final MenuOrderParser menuOrderParser = new MenuOrderParser();
    private static final InputParser inputParser = new InputParser();

    public int readDate() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        boolean validInputNumber = false;
        int inputNumber = 0;
        while (!validInputNumber) {
            try {
                String input = Console.readLine();
                inputNumber = inputParser.dateParseNumber(input);
                inputValidation.date(inputNumber);
                validInputNumber = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return inputNumber;
    }

    public List<MenuItem> readMenu() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        while (true) {
            String inputMenu = Console.readLine();
            try {
                return menuOrderParser.parseOrder(inputMenu);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
