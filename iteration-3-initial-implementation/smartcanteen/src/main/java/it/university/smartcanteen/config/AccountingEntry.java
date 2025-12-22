package it.university.smartcanteen.config;

import java.time.LocalDateTime;

public class AccountingEntry {

    private String id;
    private String ticketId;
    private double amount;
    private LocalDateTime timestamp;

    public AccountingEntry(String id, String ticketId, double amount) {
        this.id = id;
        this.ticketId = ticketId;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public double getAmount() {
        return amount;
    }
}