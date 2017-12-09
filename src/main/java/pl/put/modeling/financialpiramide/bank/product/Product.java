package pl.put.modeling.financialpiramide.bank.product;

import pl.put.modeling.financialpiramide.bank.interest.InterestSystem;
import pl.put.modeling.financialpiramide.bank.report.Report;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface Product {

	void accept(Report report);

    List<Product> getProducts();

    void setProducts(List<Product> products);

    InterestSystem getInterestSystem();

    void setInterestSystem(InterestSystem interestSystem);

    LocalDateTime getCreationDate();

    void setCreationDate(LocalDateTime creationDate);

    Long getAccountNumber();

    void setAccountNumber(Long accountNumber);

    BigDecimal calculateInterest();

    BigDecimal getBalance();

    void setBalance(BigDecimal balance);

    Boolean getActive();

    void setActive(Boolean active);
}
