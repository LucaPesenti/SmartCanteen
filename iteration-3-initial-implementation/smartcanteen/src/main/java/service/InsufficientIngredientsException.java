package service;

public class InsufficientIngredientsException extends RuntimeException {
    public InsufficientIngredientsException(String ingredientId) {
        super("Insufficient quantity for ingredient: " + ingredientId);
    }
}
