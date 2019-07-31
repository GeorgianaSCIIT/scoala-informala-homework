/***
 *
 * @author Georgiana
 *
 */

package ro.scit.storeentities;
import entities.Product;
import java.util.ArrayList;
import java.util.List;
public class Store {

    static List<SoldItem> orderList = new ArrayList<>();
    List<Product> productList;
    List<StockItem> stockList = new ArrayList<>();

    Product product = new Product();
    SoldItem sold = new SoldItem();


    public static boolean sellProduct(List orderList) {
        SoldItem sold = new SoldItem();
        Product product = new Product();
        int id = 0;
        int stockQuantity= product.getQuantity()- sold.getSoldQuantity();
        for (int i = 0; i < orderList.size(); i++) {
            if(stockQuantity == 0){
                orderList.add(new SoldItem(sold.getSellDate(), sold.getSoldQuantity()));
                System.out.println("Your order has been placed! ");

            } else {
                orderList.add(new SoldItem(sold.getSellDate(), new Product(id), sold.getSoldQuantity() ));
                System.out.println("Your order has been placed!");
            }

        }
        return true;

    }

    public void updateStocQuantity(){
        int stockQuantity= product.getQuantity()- sold.getSoldQuantity();
        System.out.println( "You have " + stockQuantity + " more products in stock!");

    }

}

