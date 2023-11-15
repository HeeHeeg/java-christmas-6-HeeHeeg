package christmas.event;

import christmas.calculation.PriceFormatter;

import java.time.LocalDate;

import static christmas.event.EventManager.*;

public class ChristmasDiscountEvent {
    private static final int BASE_DISCOUNT = 1000;
    private static final int EXTRA_DISCOUNT = 100;
    private static final PriceFormatter priceFormatter = new PriceFormatter();

    public int checkChristmasDiscountPeriod(int date) {
        LocalDate reservationDate = LocalDate.of(2023, 12, date);
        if (!isWithinChristmasEventPeriod(reservationDate)) {
            return DISCOUNT_ZERO;
        }
        long daysBetween = CHRISTMAS_EVENT_START_DATE.until(reservationDate).getDays();
        return BASE_DISCOUNT + (int) daysBetween * EXTRA_DISCOUNT;
    }

    public int getChristmasBenefitAmount(int date) {
        return checkChristmasDiscountPeriod(date);
    }

    public String christmasBenefitAmount(int date) {
        return priceFormatter.formatPrice(getChristmasBenefitAmount(date));
    }
}
