package pl.put.modeling.financialpiramide.bank.kir;

import pl.put.modeling.financialpiramide.bank.Bank;

public interface IKir {
    boolean attachBank(Bank bank);
    boolean detachBank(Bank bank);
}
