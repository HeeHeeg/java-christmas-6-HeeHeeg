package christmas;

import christmas.calculation.Calculator;
import christmas.menu.MenuItem;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class Application {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final Calculator calculator = new Calculator();

    public static void main(String[] args) {
        int date = inputView.readDate();
        List<MenuItem> orderedMenu = inputView.readMenu();
        outputView.printMenu(orderedMenu);
        int totalPrice = calculator.totalPrice(orderedMenu);
        outputView.printTotalPrice(totalPrice);
        outputView.printGiveawayMenu(date, orderedMenu);
        outputView.benefitDetails(date, orderedMenu);
        outputView.totalBenefitAmount(date, orderedMenu);
        outputView.totalPaymentAmount(date, orderedMenu);
    }
}
