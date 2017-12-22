package pl.put.modeling.financialpiramide.bank.operation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.modeling.financialpiramide.bank.interest.NewCustomerInterestSystem;
import pl.put.modeling.financialpiramide.bank.product.Account;
import pl.put.modeling.financialpiramide.bank.product.Product;

import java.math.BigDecimal;

 class DepositTest {

    private Product account;

    @BeforeEach
    void createAccount() {
        account = new Account(new NewCustomerInterestSystem(), 1L);
    }


    @Test
    void shouldDeposit300() {
        Operation deposit = new Deposit(account, new BigDecimal(300));
        deposit.operate();

        Assertions.assertEquals(new BigDecimal(300), account.getBalance());
    }

    @Test
    void shouldNotDepositNegativeAmountOfMoney() {
        Operation deposit = new Deposit(account, new BigDecimal(-500));

        Assertions.assertFalse(deposit.operate());
    }

}
