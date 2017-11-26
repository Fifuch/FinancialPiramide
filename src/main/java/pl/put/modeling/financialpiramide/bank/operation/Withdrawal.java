package pl.put.modeling.financialpiramide.bank.operation;

import pl.put.modeling.financialpiramide.bank.product.Product;

import java.math.BigDecimal;

public class Withdrawal implements Operation {
    private Product sourceAccount;
    private BigDecimal value;

    public Withdrawal(Product SourceAccount, BigDecimal Value) {
        sourceAccount = SourceAccount;
        value = Value;
    }

    @Override
    public boolean operate() {
        BigDecimal difference = sourceAccount.getBalance().subtract(value);

        if (difference.compareTo(BigDecimal.ZERO) > 0 && value.signum()==1) {
            sourceAccount.setBalance(difference);
            return true;
        }
        return false;
    }
}
