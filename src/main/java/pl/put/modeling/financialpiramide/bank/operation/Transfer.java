package pl.put.modeling.financialpiramide.bank.operation;

import pl.put.modeling.financialpiramide.bank.product.Product;

import java.math.BigDecimal;

public class Transfer implements Operation {
    private Product sourceAccount;
    private Product destinationAccount;
    private BigDecimal value;

    public Transfer(Product SourceAccount, Product DestinationAccount, BigDecimal Value) {
        sourceAccount = SourceAccount;
        destinationAccount = DestinationAccount;
        value = Value;
    }

    @Override
    public boolean operate() {
        Withdrawal withdrawal = new Withdrawal(sourceAccount, value);
        Deposit deposit = new Deposit(destinationAccount, value);

        return withdrawal.operate() && deposit.operate();
    }
}
