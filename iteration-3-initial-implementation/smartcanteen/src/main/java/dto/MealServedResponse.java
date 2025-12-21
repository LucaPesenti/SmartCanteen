package dto;

import java.time.LocalDateTime;

public class MealServedResponse {

    private String ticketId;
    private String mealName;
    private double price;
    private LocalDateTime servedAt;

    public MealServedResponse(String ticketId, String mealName, double price) {
        this.ticketId = ticketId;
        this.mealName = mealName;
        this.price = price;
        this.servedAt = LocalDateTime.now();
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getMealName() {
        return mealName;
    }

    public double getPrice() {
        return price;
    }

    public LocalDateTime getServedAt() {
        return servedAt;
    }
}
