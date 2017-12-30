package pl.put.modeling.financialpiramide.bank.report;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.modeling.financialpiramide.bank.interest.NewCustomerInterestSystem;
import pl.put.modeling.financialpiramide.bank.product.Account;
import pl.put.modeling.financialpiramide.bank.product.Product;

import java.math.BigDecimal;
import java.util.List;

class ReportAccountBalanceOver9000Test {

    private Product accountFrom, accountTo;

    @BeforeEach
    void prepareProducts() {
        accountFrom = new Account(new NewCustomerInterestSystem(), 1L);
        accountFrom.setBalance(new BigDecimal(90001));
        accountTo = new Account(new NewCustomerInterestSystem(), 2L);
        accountTo.setBalance(new BigDecimal(8000));
    }

    @Test
    void shouldReturnOneAccount() {
    	ReportAccountBalanceOver9000 report = new ReportAccountBalanceOver9000();

    	accountFrom.accept(report);
    	accountTo.accept(report);
    	List<Product> accounts = report.getReport();

    	Assertions.assertTrue(accounts.size()==1);
    }

}
