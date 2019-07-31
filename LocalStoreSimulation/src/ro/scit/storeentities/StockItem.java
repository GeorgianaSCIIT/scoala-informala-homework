package ro.scit.storeentities;

import entities.Product;
import java.util.Objects;

public class StockItem {

    Product product;
    SoldItem sold;
    Product product1 = new Product();
    SoldItem sold1 = new SoldItem();
    private int quantity;



    public StockItem(int quantity) {
        this.quantity = quantity;
    }

    public StockItem(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = product.getQuantity()- sold.getSoldQuantity();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StockItem)) return false;
        StockItem stockItem = (StockItem) o;
        return quantity == stockItem.quantity &&
                product.equals(stockItem.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, quantity);
    }

    @Override
    public String toString() {
        return "StockItem{" +
                "product=" + product +
                ", sold=" + sold +
                ", quantity=" + quantity +
                '}';
    }
}


