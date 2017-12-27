package pl.put.modeling.financialpiramide.bank.kir;

import pl.put.modeling.financialpiramide.bank.Bank;
import pl.put.modeling.financialpiramide.bank.operation.InterbankTransfer;
import pl.put.modeling.financialpiramide.bank.operation.Operation;
import pl.put.modeling.financialpiramide.bank.operation.Transfer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Kir implements IKir {
    private Map<String,Bank> banks;
    private Map<String,List<CashTransferOrder>> transferQueue;

    public Kir() {
        banks = new HashMap<>();
        transferQueue = new HashMap<>();
    }

    private boolean transfersProcessing() {
        for(String bankId : transferQueue.keySet()){
            Bank b = banks.get(bankId);
            Operation transfer = new Transfer(); //? or move to bank // and send list with oper to bank
            b.operate(transfer);
        }

        return false;
    }

    public boolean addInterbankOrder(CashTransferOrder transferOrder) {
        transferQueue.computeIfAbsent(transferOrder.getDestinationBankId(), k -> new ArrayList<>());

        return transferQueue.get(transferOrder.getDestinationBankId()).add(transferOrder);
    }

    public boolean attachBank(Bank bank) {
        banks.putIfAbsent(bank.getBankId(), bank);
        return true;
        /*List<Bank> foundBank = banks.stream()
                .filter(x -> x.getBankId().equals(bank.getBankId()))
                .collect(Collectors.toList());

        if(foundBank.isEmpty()) {
           banks.add(bank);
           return true;
        } else {
            return false;
        }*/
    }

    public boolean detachBank(Bank bank) {
        if(null != banks.get(bank.getBankId()))
            banks.remove(bank.getBankId());
        return true;
        /*List<Bank> foundBank = banks.stream()
                .filter(x -> x.getBankId().equals(bank.getBankId()))
                .collect(Collectors.toList());

        if(!foundBank.isEmpty()) {
            banks.removeAll(foundBank);
            return true;
        } else {
            return false;
        }*/
    }
}
