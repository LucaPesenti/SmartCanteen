package repository;

import org.springframework.stereotype.Repository;

import model.Meal;
import model.Ticket;

import config.SampleDataFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class TicketRepository {

    private final Map<String, Ticket> tickets = new HashMap<>();

    public TicketRepository() {
        Meal meal = SampleDataFactory.sampleMeal();
        Ticket ticket = new Ticket("T1", true, meal);
        tickets.put(ticket.getId(), ticket);
    }

    public Optional<Ticket> findById(String id) {
        return Optional.ofNullable(tickets.get(id));
    }

    public void save(Ticket ticket) {
        tickets.put(ticket.getId(), ticket);
    }
}
