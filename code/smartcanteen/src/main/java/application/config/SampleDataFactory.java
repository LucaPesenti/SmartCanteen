package application.config;

import java.util.HashMap;
import java.util.Map;

public class SampleDataFactory {

    public static Meal sampleMeal() {
        Map<String, Integer> ingredients = new HashMap<>();
        ingredients.put("I1", 100);
        ingredients.put("I2", 50);

        return new Meal("M1", "Pasta al pomodoro", 5.50, ingredients);
    }
}
