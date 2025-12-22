package it.university.smartcanteen.controller;

import it.university.smartcanteen.config.Meal;
import it.university.smartcanteen.dto.MealServedResponse;
import it.university.smartcanteen.service.MealService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final MealService mealService;

    public TicketController(MealService mealService) {
        this.mealService = mealService;
    }

    @PostMapping("/{ticketId}/serve")
    public ResponseEntity<MealServedResponse> serveMeal(@PathVariable String ticketId) {

        Meal meal = mealService.serveMeal(ticketId);

        MealServedResponse response = new MealServedResponse(
                ticketId,
                meal.getName(),
                meal.getPrice()
        );

        return ResponseEntity.ok(response);
    }
}
