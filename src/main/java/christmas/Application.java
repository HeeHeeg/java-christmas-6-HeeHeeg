package christmas;

import christmas.view.InputView;

public class Application {
    private static final InputView inputView = new InputView();
    public static void main(String[] args) {
        inputView.readDate();
    }

}
