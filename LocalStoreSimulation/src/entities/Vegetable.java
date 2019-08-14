package entities;

public class Vegetable extends Product {

    private String vitaminList;

    public Vegetable() {
    }

    public Vegetable(int id,String name, int price, int weight, int quantity, String validityDate, String vitaminList) {
        super(id, name, price, weight, quantity, validityDate);
        this.vitaminList = vitaminList;
    }


    @Override
    public String toString() {
        return "Vegetable:" + super.toString()+
                "vitaminList='" + vitaminList +
                ';';
    }
}
