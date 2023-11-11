package christmas.validation;

public class InputValidator {
    public void validateDate(int reservationDate) {
        if (!(reservationDate >= 1 && reservationDate <= 31)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public void menuQuantity(int quantity) {
        if (!(quantity >= 1)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
