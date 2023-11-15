package christmas.event;

import christmas.calculation.PriceFormatter;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static christmas.event.EventManager.isWithinDecemberEventPeriod;

public class SpecialDiscountEvent {
    private static final int DISCOUNT = 1000;
    private static final int DISCOUNT_ZERO = 0;
    private static final int SPECIAL_DAY = 25;
    private static final PriceFormatter priceFormatter = new PriceFormatter();

    public int calculateSpecialDiscount(int date) {
        LocalDate reservationDate = LocalDate.of(2023, 12, date);
        if (!isWithinDecemberEventPeriod(reservationDate)) {
            return DISCOUNT_ZERO;
        }
        if (date == SPECIAL_DAY || reservationDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return DISCOUNT;
        }
        return DISCOUNT_ZERO;
    }

    public int getSpecialBenefitAmount(int date) {
        return calculateSpecialDiscount(date);
    }

    public String specialBenefitAmount(int date) {
        return priceFormatter.formatPrice(getSpecialBenefitAmount(date));
    }
}
