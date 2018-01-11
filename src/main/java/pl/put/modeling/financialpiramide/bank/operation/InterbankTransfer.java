package pl.put.modeling.financialpiramide.bank.operation;

import pl.put.modeling.financialpiramide.bank.kir.CashTransferOrder;

import java.util.List;

public class InterbankTransfer implements Operation { // output??
    List<CashTransferOrder> transferList; //źle

    public InterbankTransfer(List<CashTransferOrder> transferList) {
        this.transferList = transferList;
    }

    @Override
    public boolean operate() {

        return false;
    }
}
