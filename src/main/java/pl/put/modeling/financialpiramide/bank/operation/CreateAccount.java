package pl.put.modeling.financialpiramide.bank.operation;

import pl.put.modeling.financialpiramide.bank.Consumer;
import pl.put.modeling.financialpiramide.bank.product.Product;

public class CreateAccount implements Operation {
    private Consumer consumer;
    private Product product;

    public CreateAccount(Consumer Consumer, Product NewProduct) {
        this.consumer = Consumer;
        this.product = NewProduct;
    }

    @Override
    public boolean operate() {
        consumer.setProduct(product);
        return true;
    }
}
