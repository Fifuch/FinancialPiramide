package pl.put.modeling.financialpiramide.bank.product;

import pl.put.modeling.financialpiramide.bank.interest.InterestSystem;
import pl.put.modeling.financialpiramide.bank.report.Report;

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
        balance = balance.subtract(debitLimit);
        account.setBalance(balance);
        if(account.getBalance().compareTo(BigDecimal.ZERO) < 0) {
            currentDebit = currentDebit.subtract(account.getBalance());
            account.setBalance(BigDecimal.ZERO);
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

	@Override
	public void accept(Report report) {
		report.visitDebitAccount(this);
	}
}
