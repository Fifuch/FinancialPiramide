package pl.put.modeling.financialpiramide.inject;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import pl.put.modeling.financialpiramide.bank.history.HistoryEntry;

import java.util.ArrayList;
import java.util.List;

public class BankModule extends AbstractModule {
    @Override
    protected void configure() {

    }

    @Provides
    private List<HistoryEntry> provideEmptyHistory() {
        return new ArrayList<>(0);
    }
}
