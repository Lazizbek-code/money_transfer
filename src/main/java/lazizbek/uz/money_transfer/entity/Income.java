package lazizbek.uz.money_transfer.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    private Card fromCardId;

    @ManyToOne(optional = false)
    private Card toCardId;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private LocalDateTime dateTime = LocalDateTime.now();

    public Income() {
    }

    public Income(Integer id, Card fromCardId, Card toCardId, Double amount, LocalDateTime dateTime) {
        this.id = id;
        this.fromCardId = fromCardId;
        this.toCardId = toCardId;
        this.amount = amount;
        this.dateTime = dateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Card getFromCardId() {
        return fromCardId;
    }

    public void setFromCardId(Card fromCardId) {
        this.fromCardId = fromCardId;
    }

    public Card getToCardId() {
        return toCardId;
    }

    public void setToCardId(Card toCardId) {
        this.toCardId = toCardId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
