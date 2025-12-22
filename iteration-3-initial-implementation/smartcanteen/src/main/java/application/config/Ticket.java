package application.config;

public class Ticket {

    private String id;
    private boolean valid;
    private boolean used;
    private Meal meal;

    public Ticket(String id, boolean valid, Meal meal) {
        this.id = id;
        this.valid = valid;
        this.used = false;
        this.meal = meal;
    }

    public String getId() {
        return id;
    }

    public boolean isValid() {
        return valid;
    }

    public boolean isUsed() {
        return used;
    }

    public Meal getMeal() {
        return meal;
    }

    public void markAsUsed() {
        this.used = true;
    }
}
