package pl.put.modeling.financialpiramide.bank.interest;

import java.math.BigDecimal;

public interface InterestSystem {
    BigDecimal calculateInterest(BigDecimal amount);
}
