package it.university.smartcanteen.repository;

import org.springframework.stereotype.Repository;

import it.university.smartcanteen.config.Ingredient;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InventoryRepository {

    private final Map<String, Ingredient> ingredients = new HashMap<>();

    public InventoryRepository() {
        ingredients.put("I1", new Ingredient("I1", "Pasta", 500));
        ingredients.put("I2", new Ingredient("I2", "Pomodoro", 300));
    }

    public Ingredient findById(String id) {
        return ingredients.get(id);
    }

    public void save(Ingredient ingredient) {
        ingredients.put(ingredient.getId(), ingredient);
    }
}
