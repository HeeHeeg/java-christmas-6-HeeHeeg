package christmas;

import christmas.menu.MenuItem;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class Application {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    public static void main(String[] args) {
        inputView.readDate();
        List<MenuItem> orderdeMenu = inputView.readMenu();
        outputView.printMenu(orderdeMenu);
    }
}
