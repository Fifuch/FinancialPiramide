package pl.put.modeling.financialpiramide.bank.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import pl.put.modeling.financialpiramide.bank.product.Account;
import pl.put.modeling.financialpiramide.bank.product.DebitAccount;
import pl.put.modeling.financialpiramide.bank.product.Loan;
import pl.put.modeling.financialpiramide.bank.product.Placement;
import pl.put.modeling.financialpiramide.bank.product.Product;

public class ReportAccountBalanceOver9000 implements Report {

	List<Product> products;

	public ReportAccountBalanceOver9000() {
		products = new ArrayList<>();
	}

	@Override
	public void visitPlacement(Placement placement) {
	}

	@Override
	public void visitAccount(Account account) {
		if(account.getBalance().compareTo(new BigDecimal(9000))==1) {
			products.add(account);
			System.out.println(account.toString());
		}
	}

	@Override
	public void visitLoan(Loan loan) {
	}

	@Override
	public void visitDebitAccount(DebitAccount debitAccount) {
		visitAccount(debitAccount.getAccount());
	}

	public List<Product> getReport() {
		return this.products;
	}

}
