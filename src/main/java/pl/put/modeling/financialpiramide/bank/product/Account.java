package pl.put.modeling.financialpiramide.bank.product;

import pl.put.modeling.financialpiramide.bank.interest.InterestSystem;
import pl.put.modeling.financialpiramide.bank.report.Report;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Account implements Product {

    private List<Product> products;
    private InterestSystem interestSystem;
    private LocalDateTime creationDate;
    private Long accountNumber;
    private BigDecimal balance;
    private Boolean isActive;

    public Account(InterestSystem interestSystem, Long accountNumber) {
        this.interestSystem = interestSystem;
        this.accountNumber = accountNumber;
        this.creationDate = LocalDateTime.now();
        this.balance = BigDecimal.ZERO;
        this.products = new ArrayList<>();
        this.isActive = true;
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public InterestSystem getInterestSystem() {
        return interestSystem;
    }

    @Override
    public void setInterestSystem(InterestSystem interestSystem) {
        this.interestSystem = interestSystem;
    }

    @Override
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    @Override
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public Long getAccountNumber() {
        return accountNumber;
    }

    @Override
    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public BigDecimal calculateInterest() {
        return interestSystem.calculateInterest(balance);
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public Boolean getActive() {
        return isActive;
    }

    @Override
    public void setActive(Boolean active) {
        isActive = active;
    }

	@Override
	public void accept(Report report) {
		report.visitAccount(this);

	}

	public String toString() {
		return "Account no. " + accountNumber
		+ ", balance: " + balance.toString();
	}
}
