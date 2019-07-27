package ro.scit.entities;
import ro.scit.storeentities.StockItem;

import java.util.List;
import java.util.Objects;

public class Product {
    private static int nextId = 1;
    private int id;
    private String type;
    private String name;
    private int price;
    private int weight;
    private int quantity;
    private String validityDate;

    public Product() {
    }

    public Product(int id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Product(int id, String name, int price, int weight, int quantity, String validityDate) {
        this.id = Product.nextId;
        Product.nextId++;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.quantity = quantity;
        this.validityDate = validityDate;
    }

    public Product(int id) {
        this.id = id;
    }

    public int getId() { return id; }

    public int getQuantity() {
        return quantity;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    public String getValidityDate() {
        return validityDate;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id == product.id &&
                price == product.price &&
                weight == product.weight &&
                quantity == product.quantity &&
                type.equals(product.type) &&
                name.equals(product.name) &&
                validityDate.equals(product.validityDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, name, price, weight, quantity, validityDate);
    }

    @Override
    public String toString() {
        return "Product: " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", quantity=" + quantity +
                ", validityDate='" + validityDate +

                ';';
    }

}
