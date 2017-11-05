package pl.put.modeling.financialpiramide.bank;

import pl.put.modeling.financialpiramide.bank.operation.Operation;

public class Bank {
    public boolean operate(Operation operation) {
        return operation.operate();
    }
}
