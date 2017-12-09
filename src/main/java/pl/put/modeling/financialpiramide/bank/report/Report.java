package pl.put.modeling.financialpiramide.bank.report;

import pl.put.modeling.financialpiramide.bank.product.Account;
import pl.put.modeling.financialpiramide.bank.product.DebitAccount;
import pl.put.modeling.financialpiramide.bank.product.Loan;
import pl.put.modeling.financialpiramide.bank.product.Placement;

public interface Report {

	public void visitPlacement(Placement placement);
	public void visitAccount(Account account);
	public void visitLoan(Loan loan);
	public void visitDebitAccount(DebitAccount debitAccount);

}
