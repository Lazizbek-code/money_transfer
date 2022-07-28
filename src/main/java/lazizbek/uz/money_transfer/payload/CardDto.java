package lazizbek.uz.money_transfer.payload;

import javax.validation.constraints.NotNull;

public class CardDto {
    @NotNull(message = "number bo'sh bo'lmasligi kerak")
    private String number;

    @NotNull(message = "expireDate bo'sh bo'lmasligi kerak")
    private String expireDate;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }
}
