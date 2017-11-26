package pl.put.modeling.financialpiramide.bank.operation;

import pl.put.modeling.financialpiramide.bank.product.Product;

public class CloseProduct implements  Operation{
    private Product product;

    public CloseProduct(Product product)
    {
        this.product = product;
    }

    @Override
    public boolean operate() {
        product.setActive(false);
        return true;
    }
}
