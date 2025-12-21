package model;

public class Ingredient {

    private String id;
    private String name;
    private int quantity;

    public Ingredient(String id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void decrease(int amount) {
        this.quantity -= amount;
    }
}
