package ro.scit.test;

import org.junit.Test;
import ro.scit.entities.Animal;
import ro.scit.entities.Product;
import ro.scit.entities.Vegetable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StoreTest {

    @Test
    public void sellProduct() {
        //int id, String name, int price, int weight, int quantity, String validityDate
        List<Product> productList = new ArrayList();

        Product p1 = new Animal(0,"milk", 3, 1, 6,"2019-09-25", 2);
        Product p2 = new Animal(1,"cheese", 3, 1, 4,"2019-09-25", 3);
        Product v1 = new Vegetable(2,"morcovi", 5, 1, 5,"2019-09-27", "abcd");

        productList.add(p1);
        productList.add(p2);
        productList.add(v1);


    }

    @Test
    public void updateStocQuantity() {
    }
}