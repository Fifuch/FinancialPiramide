package pl.put.modeling.financialpiramide.bank.operation;

import pl.put.modeling.financialpiramide.bank.Consumer;
import pl.put.modeling.financialpiramide.bank.product.Product;

import java.math.BigDecimal;

public class CreateLoan implements  Operation{
    private Consumer consumer;
    private Product consumerAccount;
    private Product consumerLoan;
    private BigDecimal value;

    public CreateLoan(Consumer consumer, Product consumerAccount, Product consumerLoan, BigDecimal value)
    {
        this.consumer = consumer;
        this.consumerAccount = consumerAccount;
        this.consumerLoan = consumerLoan;
        this.value = value;
    }

    @Override
    public boolean operate() {
        Deposit deposit = new Deposit(consumerAccount,value);
        if(deposit.operate()) {
            consumer.setProduct(consumerLoan);
            return true;
        }
        return false;
    }
}
