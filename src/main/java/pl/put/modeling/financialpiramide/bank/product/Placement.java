package pl.put.modeling.financialpiramide.bank.product;

import pl.put.modeling.financialpiramide.bank.interest.InterestSystem;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Placement implements Product {
  
    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public void setProducts(List<Product> products) {

    }

    @Override
    public InterestSystem getInterests() {
        return null;
    }

    @Override
    public void setInterests(InterestSystem interests) {

    }

    @Override
    public LocalDateTime getCreationDate() {
        return null;
    }

    @Override
    public void setCreationDate(LocalDateTime creationDate) {

    }

    @Override
    public Long getAccountNumber() {
        return null;
    }

    @Override
    public void setAccountNumber(Long accountNumber) {

    }

    @Override
    public BigDecimal getBalance() {
        return null;
    }

    @Override
    public void setBalance(BigDecimal balance) {

    }
}
