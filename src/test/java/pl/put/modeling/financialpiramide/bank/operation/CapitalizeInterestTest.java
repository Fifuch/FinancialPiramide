package pl.put.modeling.financialpiramide.bank.operation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import pl.put.modeling.financialpiramide.bank.interest.NewCustomerInterestSystem;
import pl.put.modeling.financialpiramide.bank.product.Account;
import pl.put.modeling.financialpiramide.bank.product.Product;

import java.math.BigDecimal;

public class CapitalizeInterestTest {

    Product account;

    @Before
    public void createAccount() {
        account = new Account(new NewCustomerInterestSystem(), 1L);
    }

    @Test
    @DisplayName("Capitalize additional 666 on account")
    public void shouldCapitalize666(){
        account.setBalance(new BigDecimal(100000));
        CapitalizeInterest capitalizeInterest = new CapitalizeInterest(account);
        capitalizeInterest.operate();

        Assert.assertTrue(new BigDecimal("100666").compareTo(account.getBalance().setScale(2,BigDecimal.ROUND_FLOOR))==0);
    }

    @Test
    @DisplayName("Do not capitalize")
    public void shouldNotCapitalizeAnything(){
        account.setBalance(new BigDecimal(0));
        CapitalizeInterest capitalizeInterest = new CapitalizeInterest(account);
        capitalizeInterest.operate();

        Assert.assertTrue(new BigDecimal(0).compareTo(account.getBalance().setScale(2,BigDecimal.ROUND_FLOOR))==0);
    }
}
