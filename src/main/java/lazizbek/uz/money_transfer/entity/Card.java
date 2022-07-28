package lazizbek.uz.money_transfer.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private String number;

    private Double balance = 1_000_000.0;

    private String currency = "UZS";

    @Column(nullable = false)
    private String expireDate;

    @Column(nullable = false)
    private Boolean active = true;

    public Card() {
    }

    public Card(Integer id, String username, String number, Double balance, String currency, String expireDate, Boolean active) {
        this.id = id;
        this.username = username;
        this.number = number;
        this.balance = balance;
        this.currency = currency;
        this.expireDate = expireDate;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
