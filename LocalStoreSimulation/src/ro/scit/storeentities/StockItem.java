package ro.scit.storeentities;

import entities.Product;
import java.util.Objects;

public class StockItem {

    Product product;
    SoldItem sold;
    private int quantity;


    public StockItem(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
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


