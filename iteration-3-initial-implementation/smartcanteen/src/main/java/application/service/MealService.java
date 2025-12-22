package application.service;

import org.springframework.stereotype.Service;

import application.config.AccountingEntry;
import application.config.Ingredient;
import application.config.Meal;
import application.config.Ticket;
import application.repository.AccountingRepository;
import application.repository.InventoryRepository;
import application.repository.TicketRepository;

import java.util.Map;
import java.util.UUID;

@Service
public class MealService {

    private final TicketRepository ticketRepository;
    private final InventoryRepository inventoryRepository;
    private final AccountingRepository accountingRepository;

    public MealService(TicketRepository ticketRepository,
                       InventoryRepository inventoryRepository,
                       AccountingRepository accountingRepository) {
        this.ticketRepository = ticketRepository;
        this.inventoryRepository = inventoryRepository;
        this.accountingRepository = accountingRepository;
    }

    public Meal serveMeal(String ticketId) {

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new TicketNotFoundException(ticketId));

        if (!ticket.isValid() || ticket.isUsed()) {
            throw new InvalidTicketException("Ticket is invalid or already used");
        }

        Meal meal = ticket.getMeal();

        checkAndConsumeIngredients(meal);

        ticket.markAsUsed();
        ticketRepository.save(ticket);

        AccountingEntry entry = new AccountingEntry(
                UUID.randomUUID().toString(),
                ticket.getId(),
                meal.getPrice()
        );
        accountingRepository.save(entry);

        return meal;
    }

    private void checkAndConsumeIngredients(Meal meal) {
        for (Map.Entry<String, Integer> required : meal.getIngredients().entrySet()) {

            Ingredient ingredient = inventoryRepository.findById(required.getKey());

            if (ingredient == null || ingredient.getQuantity() < required.getValue()) {
                throw new InsufficientIngredientsException(required.getKey());
            }

            ingredient.decrease(required.getValue());
            inventoryRepository.save(ingredient);
        }
    }
}
