package pl.put.modeling.financialpiramide.bank.operation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.put.modeling.financialpiramide.bank.interest.NewCustomerInterestSystem;
import pl.put.modeling.financialpiramide.bank.product.Account;
import pl.put.modeling.financialpiramide.bank.product.Product;

import java.math.BigDecimal;

class TransferTest {
	
    private Product accountFrom, accountTo;

    @BeforeEach
    void prepareProducts() {
        accountFrom = new Account(new NewCustomerInterestSystem(), 50L);
        accountFrom.setBalance(new BigDecimal(100));
        accountTo = new Account(new NewCustomerInterestSystem(), 50L);
        accountTo.setBalance(new BigDecimal(100));
    }

    @Test
    @DisplayName("Transfer lesser than 'from' balance")
    void testTransferLesserThanBalance() {
       Operation transfer = new Transfer(accountFrom, accountTo, new BigDecimal(50));
       transfer.operate();
        Assertions.assertEquals(new BigDecimal(50), accountFrom.getBalance());
        Assertions.assertEquals(new BigDecimal(150), accountTo.getBalance());
    }

    @Test
    @DisplayName("Transfer bigger than 'from' balance")
    void testTransferBiggerThanBalance() {
        Operation transfer = new Transfer(accountFrom, accountTo, new BigDecimal(150));
        transfer.operate();
        Assertions.assertEquals(new BigDecimal(100), accountFrom.getBalance());
        Assertions.assertEquals(new BigDecimal(100), accountTo.getBalance());
    }

    @Test
    @DisplayName("Transfer negative amount")
    void testTransferNegativeAmount() {
        Operation transfer = new Transfer(accountFrom, accountTo, new BigDecimal(-50));
        transfer.operate();
        Assertions.assertEquals(new BigDecimal(100), accountFrom.getBalance());
        Assertions.assertEquals(new BigDecimal(100), accountTo.getBalance());
    }
}
