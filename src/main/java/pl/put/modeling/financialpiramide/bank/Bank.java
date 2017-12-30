package pl.put.modeling.financialpiramide.bank;

import pl.put.modeling.financialpiramide.bank.history.HistoryEntry;
import pl.put.modeling.financialpiramide.bank.kir.Kir;
import pl.put.modeling.financialpiramide.bank.operation.Operation;

import javax.inject.Inject;
import java.util.List;

public class Bank {
    List<HistoryEntry> history;
    String bankId;
    Kir kir;

    @Inject
    public Bank(String bankId, List<HistoryEntry> history, Kir kir) {
        this.bankId = bankId;
        this.history = history;
        this.kir = kir;
    }

    public boolean operate(Operation operation) {
        return operation.operate();
    }

    public String getBankId() { return bankId; }

    public List<HistoryEntry> getHistory() {
        return history;
    }
}
