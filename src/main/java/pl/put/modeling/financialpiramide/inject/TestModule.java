package pl.put.modeling.financialpiramide.inject;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import pl.put.modeling.financialpiramide.bank.history.HistoryEntry;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestModule extends AbstractModule {
    @Override
    protected void configure() {

    }

    @Provides
    private BigDecimal provideEmptyHistory() {
        return new BigDecimal(50);
    }
}
