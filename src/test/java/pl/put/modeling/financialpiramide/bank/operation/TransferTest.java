package pl.put.modeling.financialpiramide.bank.operation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import pl.put.modeling.financialpiramide.bank.interest.NewCustomerInterestSystem;
import pl.put.modeling.financialpiramide.bank.product.Account;
import pl.put.modeling.financialpiramide.bank.product.Product;

import java.math.BigDecimal;

public class TransferTest {
	
    private Product accountFrom, accountTo;

    @Before
    public void prepareProducts() {
        accountFrom = new Account(new NewCustomerInterestSystem(), 50L);
        accountFrom.setBalance(new BigDecimal(100));
        accountTo = new Account(new NewCustomerInterestSystem(), 50L);
        accountTo.setBalance(new BigDecimal(100));
    }

    @Test
    @DisplayName("Transfer lesser than 'from' balance")
    public void testTransferLesserThanBalance() {
       Operation transfer = new Transfer(accountFrom, accountTo, new BigDecimal(50));
       transfer.operate();
        Assert.assertEquals(new BigDecimal(50), accountFrom.getBalance());
        Assert.assertEquals(new BigDecimal(150), accountTo.getBalance());
    }

    @Test
    @DisplayName("Transfer bigger than 'from' balance")
    public void testTransferBiggerThanBalance() {
        Operation transfer = new Transfer(accountFrom, accountTo, new BigDecimal(150));
        transfer.operate();
        Assert.assertEquals(new BigDecimal(100), accountFrom.getBalance());
        Assert.assertEquals(new BigDecimal(100), accountTo.getBalance());
    }

    @Test
    @DisplayName("Transfer negative amount")
    public void testTransferNegativeAmount() {
        Operation transfer = new Transfer(accountFrom, accountTo, new BigDecimal(-50));
        transfer.operate();
        Assert.assertEquals(new BigDecimal(100), accountFrom.getBalance());
        Assert.assertEquals(new BigDecimal(100), accountTo.getBalance());
    }
}
