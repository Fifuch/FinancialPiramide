package pl.put.modeling.financialpiramide.bank.operation;

import pl.put.modeling.financialpiramide.bank.product.Product;

import java.math.BigDecimal;

public class Deposit implements  Operation{
    private Product destinationAccount;
    private BigDecimal value;

    public Deposit(Product destinationAccount, BigDecimal value)
    {
        this.destinationAccount = destinationAccount;
        this.value = value;
    }

    @Override
    public boolean operate()
    {
        if (value.compareTo(BigDecimal.ZERO) > 0) {
            destinationAccount.setBalance(destinationAccount.getBalance().add(value));
            return true;
        }
        return false;
    }
}
