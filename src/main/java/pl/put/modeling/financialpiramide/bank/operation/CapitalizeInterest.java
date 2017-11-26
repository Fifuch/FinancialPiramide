package pl.put.modeling.financialpiramide.bank.operation;

import pl.put.modeling.financialpiramide.bank.product.Account;
import pl.put.modeling.financialpiramide.bank.product.Product;

import java.math.BigDecimal;

public class CapitalizeInterest implements Operation {

    Product account;

    public CapitalizeInterest(Product account){
        this.account = account;
    }


    @Override
    public boolean operate() {
        BigDecimal interest = account.getInterestSystem().calculateInterest(account.getBalance());

        return interest.signum() == 1 && new Deposit(account, interest).operate();
    }
}
