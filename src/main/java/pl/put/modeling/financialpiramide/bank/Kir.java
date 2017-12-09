package pl.put.modeling.financialpiramide.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Kir {
    private List<Bank> banks;

    public Kir() {
        banks = new ArrayList<>();
    }

    public boolean attachBank(Bank bank) {
        List<Bank> foundBank = banks.stream()
                .filter(x -> x.getBankId().equals(bank.getBankId()))
                .collect(Collectors.toList());

        if(foundBank.isEmpty()) {
           banks.add(bank);
           return true;
        } else {
            return false;
        }
    }

    public boolean detachBank(Bank bank) {
        List<Bank> foundBank = banks.stream()
                .filter(x -> x.getBankId().equals(bank.getBankId()))
                .collect(Collectors.toList());

        if(!foundBank.isEmpty()) {
            banks.removeAll(foundBank);
            return true;
        } else {
            return false;
        }
    }
}
