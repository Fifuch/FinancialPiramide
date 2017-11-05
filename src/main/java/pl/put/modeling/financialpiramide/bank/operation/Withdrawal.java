package pl.put.modeling.financialpiramide.bank.operation;

import pl.put.modeling.financialpiramide.bank.product.Product;

import java.math.BigDecimal;

public class Withdrawal implements Operation {
    private Product _sourceAccount;
    private BigDecimal _value;

    public Withdrawal(Product SourceAccount, BigDecimal Value) {
        _sourceAccount = SourceAccount;
        _value = Value;
    }

    @Override
    public boolean operate() {
        BigDecimal difference = _sourceAccount.getBalance().subtract(_value);

        if (difference.compareTo(BigDecimal.ZERO) > 0) {
            _sourceAccount.setBalance(difference);
            return true;
        }
        return false;
    }
}
