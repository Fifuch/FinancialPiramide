package pl.put.modeling.financialpiramide.bank.interest;

import java.math.BigDecimal;

public class NewCustomerInterestSystem implements InterestSystem {

    private BigDecimal percent = new BigDecimal(0.00666);

    @Override
    public BigDecimal calculateInterest(BigDecimal amount) {
        return amount.multiply(percent);
    }
}
