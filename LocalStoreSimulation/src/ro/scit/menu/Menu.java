package ro.scit.menu;

import entities.Animal;
import entities.Product;
import entities.Vegetable;
import ro.scit.storeentities.SoldItem;
import ro.scit.storeentities.StockItem;

import java.util.*;

/**
 * @author Georgiana
 * Menu Class
 */


public class Menu {
    Scanner sc = new Scanner(System.in);
    List<Product> productList = new ArrayList<>();
    List<SoldItem>  orderList = new ArrayList<>();
    List <StockItem> stockList = new ArrayList<>();

    Product product = new Product();
    StockItem stock = new StockItem(new Product());

    public void display() {
        int selection = 0;
        while (selection != 4) {
            System.out.println(
                    "Select an option: \n" +
                            "  1) Create product and add it to stock\n" +
                            "  2) Sell product\n" +
                            "  3) Display daily sales report \n" +
                            "  4) Exit\n "
            );

            selection = sc.nextInt();
            sc.nextLine();
            switch (selection) {
                case 1:
                    System.out.println("Product type (1 - animal; 2 - vegetable): ");
                    int type = sc.nextInt();
                    //Animal product
                    if (type == 1) {
                        int id = 0;
                        Animal animal = new Animal();
                        animal.setType("ANIMAL");
                        System.out.println("Animal products: milk; eggs; cheese; yougurt; sourcream)");
                        String animalName = sc.next();
                        if (animalName.equals("milk")) {
                            animal.getMILK();
                        } else if (animalName.equals("eggs")) {
                            animal.getEGGS();
                        } else if (animalName.equals("cheese")) {
                            animal.getCHEESE();
                        } else if (animalName.equals("yougurt")) {
                            animal.getYOGURT();
                        } else if (animalName.equals("sourcream")) {
                            animal.getSOURCREAM();
                        } else {
                            System.out.println("Invalid option! Please try again!");
                        }
                        System.out.println("Enter the price of the product: ");
                        int price = sc.nextInt();
                        System.out.println("Enter the weight of the product: ");
                        int weight = sc.nextInt();
                        System.out.println("Enter the quantity of the product: ");
                        int quantity = sc.nextInt();
                        System.out.println("Enter the validity date  with format yyyy-MM-dd format:");
                        String validityDate = sc.next();
                        System.out.println("Enter the storage temperature: ");
                        int storageTemperature = sc.nextInt();
                            productList.add(new Animal(id, animalName, price, weight, quantity, validityDate, storageTemperature));
                            System.out.println("Your product is in stock! ");
                        // Vegetable product
                    } else if (type == 2) {
                        int id = 0;
                        Vegetable vegetable = new Vegetable();
                        vegetable.setType("VEGETABLE");
                        System.out.println("Enter the name of the vegetable: ");
                        String name = sc.next();
                        System.out.println("Enter the price of the product: ");
                        int price = sc.nextInt();
                        System.out.println("Enter the weight of the product: ");
                        int weight = sc.nextInt();
                        System.out.println("Enter the quantity of the product: ");
                        int quantity = sc.nextInt();
                        System.out.println("Enter the validity date with format yyyy-MM-dd format");
                        String validityDate = sc.next();
                        System.out.println("Enter list of vitamins: ");
                        String vitaminList = sc.next();
                        productList.add(new Vegetable(id, name, price, weight, quantity, validityDate, vitaminList));
                        System.out.println("Your product is in stock! ");
                    } else {
                        System.out.println("Invalid option! Please try again!");
                    }
                    break;
                case 2:
                    productList.forEach(System.out::println);
                    System.out.println("=================================");
                    System.out.println("Insert the date with format yyyy-MM-dd format ");
                    String sellDate = sc.next();
                    System.out.println("Insert the id of the product: ");
                    int id = sc.nextInt();
                        System.out.println("Insert the quantity: ");
                        int soldQuantity = sc.nextInt();
                        int quantity = product.getQuantity();
                        int stockQuantity = stock.getQuantity();
                        if(soldQuantity < quantity){
                            orderList.add(new SoldItem(sellDate, soldQuantity));
                            System.out.println("Your order has been created! ");
                            continue;
                        } else if(stockQuantity == 0) {
                            orderList.add(new SoldItem(sellDate, product, soldQuantity));
                            System.out.println("Your order has been created! ");
                        }

//                    Store store = new Store();
//                    store.sellProduct(orderList);
//                    store.updateStocQuantity();

                    break;
                case 3:
                    System.out.println("Insert the date: ");
                    String sellDate1 = sc.next();
                    SoldItem sold = new SoldItem();
                    sold.getSellDate();
                    orderList.forEach(System.out::println);
                    System.out.println("Your sales are: " + product.getId() + stock.getQuantity());
                    break;
                case 4:
                    this.exit();
                    break;
                default:
                    System.out.println("Invalid selection.");
                    break;
            }
        }
    }

        private void exit () {
            System.out.println("Exiting...");
            System.exit(1);

        }
    }
