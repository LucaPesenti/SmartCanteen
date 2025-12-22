package it.university.smartcanteen.config;

import java.util.Map;

public class Meal {

    private String id;
    private String name;
    private double price;
    private Map<String, Integer> ingredients;

    public Meal(String id, String name, double price, Map<String, Integer> ingredients) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Map<String, Integer> getIngredients() {
        return ingredients;
    }
}
