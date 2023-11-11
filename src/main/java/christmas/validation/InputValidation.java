package christmas.validation;

public class InputValidation {
    public void days(int reservationDate) {
        if (!(reservationDate >= 1 && reservationDate <= 31)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
}
