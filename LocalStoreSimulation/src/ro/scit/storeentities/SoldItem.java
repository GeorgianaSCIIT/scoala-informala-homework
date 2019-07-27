package ro.scit.storeentities;


import ro.scit.entities.Product;

import java.util.Objects;

public class SoldItem {

    private String sellDate;
    Product product;
    private int soldQuantity;
    StockItem stock;

    public SoldItem(String sellDate, Product product, int soldQuantity) {
        this.sellDate = sellDate;
        this.product = product;
        this.soldQuantity = soldQuantity;
    }


    public SoldItem(String sellDate, int soldQuantity) {
        this.sellDate = sellDate;
        this.soldQuantity = soldQuantity;
    }


    public SoldItem() {
    }

    public SoldItem(String sellDate) {
        this.sellDate = sellDate;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public String getSellDate() {
        return sellDate;
    }

    public Product getProduct() {
        return product;
    }

    public StockItem getStock() {
        return stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SoldItem)) return false;
        SoldItem soldItem = (SoldItem) o;
        return soldQuantity == soldItem.soldQuantity &&
                sellDate.equals(soldItem.sellDate) &&
                stock.equals(soldItem.stock) &&
                product.equals(soldItem.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sellDate, soldQuantity, stock, product);
    }

    @Override
    public String toString() {
        return "SoldItem:" +
                "sellDate='" + sellDate + '\'' +
                ", product id=" + product.getId()+
                ", quantity=" + soldQuantity +
                ';';
    }
}
