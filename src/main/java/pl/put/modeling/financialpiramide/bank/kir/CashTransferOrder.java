package pl.put.modeling.financialpiramide.bank.kir;

import java.math.BigDecimal;

public class CashTransferOrder {
    String sourceUserId;
    String sourceBankId;
    String destinationUserId;
    String destinationBankId;
    BigDecimal value;

    public CashTransferOrder(String sourceUserId, String sourceBankId,
                             String destinationUserId, String destinationBankId,
                             BigDecimal value) {
        this.sourceUserId = sourceUserId;
        this.sourceBankId = sourceBankId;
        this.destinationUserId = destinationUserId;
        this.destinationBankId = destinationBankId;
        this.value = value;
    }

    public String getSourceUserId() { return sourceUserId; }

    public String getSourceBankId() { return sourceBankId; }

    public String getDestinationUserId() { return destinationUserId; }

    public String getDestinationBankId() { return destinationBankId; }

    public BigDecimal getValue() { return value; }
}
