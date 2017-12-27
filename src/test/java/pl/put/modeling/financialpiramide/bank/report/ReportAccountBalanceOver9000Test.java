package pl.put.modeling.financialpiramide.bank.report;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import pl.put.modeling.financialpiramide.bank.interest.NewCustomerInterestSystem;
import pl.put.modeling.financialpiramide.bank.product.Account;
import pl.put.modeling.financialpiramide.bank.product.Product;

public class ReportAccountBalanceOver9000Test {

    private Product accountFrom, accountTo;

    @Before
    public void prepareProducts() {
        accountFrom = new Account(new NewCustomerInterestSystem(), 1L);
        accountFrom.setBalance(new BigDecimal(90001));
        accountTo = new Account(new NewCustomerInterestSystem(), 2L);
        accountTo.setBalance(new BigDecimal(8000));
    }

    @Test
    public void shouldReturnOneAccount() {
    	ReportAccountBalanceOver9000 report = new ReportAccountBalanceOver9000();

    	accountFrom.accept(report);
    	accountTo.accept(report);
    	List<Product> accounts = report.getReport();

    	assertTrue(accounts.size()==1);
    }

}
