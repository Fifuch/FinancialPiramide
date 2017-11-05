package pl.put.modeling.financialpiramide.bank.history;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import pl.put.modeling.financialpiramide.bank.Bank;

import javax.inject.Inject;

@Aspect
public class HistoryLogger {
    private Bank bank;

    @Inject
    public HistoryLogger(Bank bank) {
        this.bank = bank;
    }

    @Around("execution(* pl.put.modeling.financialpiramide.bank.operation.Operation.operate(..))")
    public void addHistoryEntry(JoinPoint operation) {

    }

}
