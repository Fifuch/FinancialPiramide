package pl.put.modeling.financialpiramide.bank.product;

import pl.put.modeling.financialpiramide.bank.interest.InterestSystem;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class DebitAccount implements Product {
    private Account account;
    private BigDecimal debitLimit;
    private BigDecimal currentDebit;

    public DebitAccount(Account account, BigDecimal debitLimit) {
        this.account = account;
        this.debitLimit = debitLimit;
        currentDebit = new BigDecimal(0);
    }

    public Account getAccount() {
        return account;
    }

    public BigDecimal getDebitLimit() {
        return debitLimit;
    }

    public BigDecimal getCurrentDebit() {
        return currentDebit;
    }

    @Override
    public List<Product> getProducts() {
        return account.getProducts();
    }

    @Override
    public void setProducts(List<Product> products) {
        account.setProducts(products);
    }

    @Override
    public InterestSystem getInterestSystem() {
        return account.getInterestSystem();
    }

    @Override
    public void setInterestSystem(InterestSystem interestSystem) {
        account.setInterestSystem(interestSystem);
    }

    @Override
    public LocalDateTime getCreationDate() {
        return account.getCreationDate();
    }

    @Override
    public void setCreationDate(LocalDateTime creationDate) {
        account.setCreationDate(creationDate);
    }

    @Override
    public Long getAccountNumber() {
        return account.getAccountNumber();
    }

    @Override
    public void setAccountNumber(Long accountNumber) {
        account.setAccountNumber(accountNumber);
    }

    @Override
    public BigDecimal calculateInterest() {
        return account.calculateInterest();
    }

    @Override
    public BigDecimal getBalance() {
        return account.getBalance().add(debitLimit).subtract(currentDebit);
    }

    @Override
    public void setBalance(BigDecimal balance) {
        if(currentDebit.compareTo(balance) >= 0) {
            currentDebit = currentDebit.subtract(currentDebit);
        } else {
            balance = balance.subtract(currentDebit);
            currentDebit = new BigDecimal(0);
            account.setBalance(balance);
        }
    }

    @Override
    public Boolean getActive() {
        return account.getActive();
    }

    @Override
    public void setActive(Boolean active) {
        account.setActive(active);
    }
}
