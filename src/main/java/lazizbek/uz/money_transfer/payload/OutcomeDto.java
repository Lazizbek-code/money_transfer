package lazizbek.uz.money_transfer.payload;

import javax.validation.constraints.NotNull;

public class OutcomeDto {
    @NotNull(message = "fromCardId bo'sh bo'lmasligi kerak")
    private Integer fromCardId;

    @NotNull(message = "toCardId bo'sh bo'lmasligi kerak")
    private Integer toCardId;

    @NotNull(message = "amount bo'sh bo'lmasligi kerak")
    private Double amount;

    public Integer getFromCardId() {
        return fromCardId;
    }

    public void setFromCardId(Integer fromCardId) {
        this.fromCardId = fromCardId;
    }

    public Integer getToCardId() {
        return toCardId;
    }

    public void setToCardId(Integer toCardId) {
        this.toCardId = toCardId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
