package pl.put.modeling.financialpiramide.bank.operation;

import pl.put.modeling.financialpiramide.bank.product.Product;

import java.math.BigDecimal;

public class Deposit implements  Operation{
    private Product _destinationAccount;
    private BigDecimal _value;

    public Deposit(Product DestinationAccount, BigDecimal Value)
    {
        _destinationAccount = DestinationAccount;
        _value = Value;
    }

    @Override
    public boolean operate()
    {
        _destinationAccount.setBalance(_destinationAccount.getBalance().add(_value));
        return true;
    }
}
