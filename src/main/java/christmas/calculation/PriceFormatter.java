package christmas.calculation;

import java.text.NumberFormat;

public class PriceFormatter {
    public String formatPrice(int price) {
        return NumberFormat.getInstance().format(price);
    }
}
