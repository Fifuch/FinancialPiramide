package pl.put.modeling.financialpiramide.bank;

import pl.put.modeling.financialpiramide.bank.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Consumer {
    private Long consumerId;
    private String firstName;
    private String surname;
    private String idNumber;
    private List<Product> products;

    public Consumer(Long consumerId, String firstName, String surname, String idNumber) {
        this.consumerId = consumerId;
        this.firstName = firstName;
        this.surname = surname;
        this.idNumber = idNumber;
        this.products = new ArrayList<>();
    }

    public Long getConsumerId() {
        return consumerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setProduct(Product product) {this.products.add(product);}

}
