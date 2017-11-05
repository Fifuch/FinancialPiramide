package pl.put.modeling.financialpiramide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import pl.put.modeling.financialpiramide.bank.Bank;
import pl.put.modeling.financialpiramide.inject.BankModule;

public class App {
    public static void main(String... args) {
        Injector injector = Guice.createInjector(new BankModule());
        Bank bank = injector.getInstance(Bank.class);
    }
}
