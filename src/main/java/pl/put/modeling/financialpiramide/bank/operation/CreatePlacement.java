package pl.put.modeling.financialpiramide.bank.operation;

import pl.put.modeling.financialpiramide.bank.Consumer;
import pl.put.modeling.financialpiramide.bank.product.Product;

import java.math.BigDecimal;

public class CreatePlacement implements  Operation {
    private Consumer consumer;
    private Product consumerAccount;
    private Product consumerPlacement;
    private BigDecimal value;

    public CreatePlacement(Consumer consumer, Product consumerAccount, Product consumerPlacement, BigDecimal value)
    {
        this.consumer = consumer;
        this.consumerAccount = consumerAccount;
        this.consumerPlacement = consumerPlacement;
        this.value = value;
    }

    @Override
    public boolean operate() {
        Withdrawal withdrawal = new Withdrawal(consumerAccount,value);
        if(withdrawal.operate()) {
            consumer.setProduct(consumerPlacement);
            return true;
        }
        else
            return false;
    }
}
