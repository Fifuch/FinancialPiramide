package pl.put.modeling.financialpiramide.bank.operation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.put.modeling.financialpiramide.bank.interest.NewCustomerInterestSystem;
import pl.put.modeling.financialpiramide.bank.product.Account;
import pl.put.modeling.financialpiramide.bank.product.DebitAccount;
import pl.put.modeling.financialpiramide.bank.product.Product;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WithdrawalTest {

    private Product account;
    private DebitAccount debitAccount;

    @BeforeEach
    void setSampleAccount() {
        account = new Account(new NewCustomerInterestSystem(), 0L);
        debitAccount = new DebitAccount((Account) account, new BigDecimal(100));
    }

    @Test
    @DisplayName("Withdraw 50 PLN from empty account")
    void subtractionWithNoCash() {
        Operation withdrawalOf50PLN = new Withdrawal(account, new BigDecimal(50));
        withdrawalOf50PLN.operate();
        assertEquals(new BigDecimal(0), account.getBalance());
    }

    @Test
    @DisplayName("Withdraw 50 PLN from account with cash")
    void substractionWithCash() {
        Operation desposit = new Deposit(account, new BigDecimal(100));
        desposit.operate();
        Operation withdrawal = new Withdrawal(account, new BigDecimal(50));
        withdrawal.operate();
        assertEquals(new BigDecimal(50), account.getBalance());
    }

    @Test
    @DisplayName("Withdraw -50PLN from empty account")
    void additionToAccount() {
        Operation withdrawal = new Withdrawal(account, new BigDecimal(-50));
        withdrawal.operate();
        assertEquals(new BigDecimal(0), account.getBalance());
    }

    @Test
    @DisplayName("Withdraw 50PLN from empty account with 100PLN debit possible.")
    void testWithdrawalFromDebitAccount() {
        Operation withdrawal = new Withdrawal(debitAccount, new BigDecimal(50));
        withdrawal.operate();
        assertEquals(new BigDecimal(50), debitAccount.getBalance());
        assertEquals(new BigDecimal(0), debitAccount.getAccount().getBalance());
    }
}
