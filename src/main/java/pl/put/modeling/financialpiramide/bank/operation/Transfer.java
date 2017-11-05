package pl.put.modeling.financialpiramide.bank.operation;

import pl.put.modeling.financialpiramide.bank.product.Product;

import java.math.BigDecimal;

public class Transfer implements Operation {
    private Product _sourceAccount;
    private Product _destinationAccount;
    private BigDecimal _value;

    public Transfer(Product SourceAccount, Product DestinationAccount, BigDecimal Value)
    {
        _sourceAccount = SourceAccount;
        _destinationAccount = DestinationAccount;
        _value = Value;
    }
    @Override
    public boolean operate() {
        Withdrawal withdrawal = new Withdrawal(_sourceAccount, _value);
        Deposit deposit = new Deposit(_destinationAccount, _value);

        return withdrawal.operate() && deposit.operate();
    }
}
