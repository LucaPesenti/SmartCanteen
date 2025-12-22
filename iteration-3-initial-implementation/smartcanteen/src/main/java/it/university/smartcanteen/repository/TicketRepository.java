package it.university.smartcanteen.repository;

import org.springframework.stereotype.Repository;

import it.university.smartcanteen.config.Meal;
import it.university.smartcanteen.config.SampleDataFactory;
import it.university.smartcanteen.config.Ticket;

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
