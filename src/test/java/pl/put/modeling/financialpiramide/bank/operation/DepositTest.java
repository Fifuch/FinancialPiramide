package pl.put.modeling.financialpiramide.bank.operation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.put.modeling.financialpiramide.bank.interest.InterestSystem;
import pl.put.modeling.financialpiramide.bank.interest.NewCustomerInterestSystem;
import pl.put.modeling.financialpiramide.bank.product.Account;
import pl.put.modeling.financialpiramide.bank.product.Product;

import java.math.BigDecimal;

public class DepositTest {

    private Product account;

    @Before
    public void createAccount() {
        account = new Account(new NewCustomerInterestSystem(), 1L);
    }


    @Test
    public void shouldDeposit300() {
        Operation deposit = new Deposit(account, new BigDecimal(300));
        deposit.operate();

        Assert.assertEquals(new BigDecimal(300), account.getBalance());
    }

    @Test
    public void shouldNotDepositNegativeAmountOfMoney() {
        Operation deposit = new Deposit(account, new BigDecimal(-500));

        Assert.assertFalse(deposit.operate());
    }

}
