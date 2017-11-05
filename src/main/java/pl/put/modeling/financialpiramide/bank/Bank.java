package pl.put.modeling.financialpiramide.bank;

import pl.put.modeling.financialpiramide.bank.history.HistoryEntry;
import pl.put.modeling.financialpiramide.bank.operation.Operation;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class Bank {
    List<HistoryEntry> history;

    @Inject
    public Bank(List<HistoryEntry> history) {
        this.history = history;
    }

    public boolean operate(Operation operation) {
        return operation.operate();
    }

    public List<HistoryEntry> getHistory() {
        return history;
    }
}
