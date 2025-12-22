package service;

import model.Meal;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MealServiceIntegrationTest {

    @Autowired
    private MealService mealService;

    @Test
    void serveMeal_withValidTicket_shouldReturnMeal() {
        Meal meal = mealService.serveMeal("T1");

        assertNotNull(meal);
        assertEquals("Pasta al pomodoro", meal.getName());
    }

    @Test
    void serveMeal_withInvalidTicket_shouldThrowException() {
        assertThrows(
                TicketNotFoundException.class,
                () -> mealService.serveMeal("INVALID")
        );
    }
}
