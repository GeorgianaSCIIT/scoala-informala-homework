package ro.scit.entities;

import java.util.Objects;

public class Animal extends Product {

    private static final String MILK = "milk";
    private static final String EGGS = "eggs";
    private static final String CHEESE = "cheese";
    private static final String YOGURT = "yogurt";
    private static final String SOURCREAM = "sourcream";

    private int storageTemperature;


    public Animal() {
    }

    public Animal(int id, String name, int price, int weight, int quantity, String validityDate, int storageTemperature) {
        super(id, name, price, weight, quantity, validityDate);
        this.storageTemperature = storageTemperature;
    }

    public static String getMILK() {
        System.out.println("You will add   : milk ");
        return MILK;
    }

    public static String getEGGS() {
        System.out.println("You will add: eggs");
        return EGGS;
    }

    public static String getCHEESE() {
        System.out.println("You will add : cheese");
        return CHEESE;
    }

    public static String getYOGURT() {
        System.out.println("You will add : yogurt");
        return YOGURT;
    }

    public static String getSOURCREAM() {
        System.out.println("You will add : sourcream");
        return SOURCREAM;
    }


    @Override
    public String toString() {
        return "Animal:" + super.toString()+
                ", storageTemperature=" + storageTemperature +
                ';';
    }
}
