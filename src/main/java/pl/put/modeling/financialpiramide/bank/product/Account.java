package pl.put.modeling.financialpiramide.bank.product;

import pl.put.modeling.financialpiramide.bank.interest.InterestSystem;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Account implements Product {

    private List<Product> products;
    private InterestSystem interests;
    private LocalDateTime creationDate;
    private Long accountNumber;
    private BigDecimal balance;


    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public InterestSystem getInterests() {
        return interests;
    }

    public void setInterests(InterestSystem interests) {
        this.interests = interests;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
