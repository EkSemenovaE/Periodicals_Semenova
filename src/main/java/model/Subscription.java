package model;

import java.time.LocalDateTime;

public class Subscription {
    private int id;
    private int userId;
    private int periodicalId;
    private LocalDateTime dateAdded;

    public Subscription(int id, int userId, int periodicalId, LocalDateTime dateAdded) {
        this.id = id;
        this.userId = userId;
        this.periodicalId = periodicalId;
        this.dateAdded = dateAdded;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {

        this.userId = userId;
    }

    public int getPeriodicalId() {
        return periodicalId;
    }

    public void setPeriodicalId(int periodicalId) {

        this.periodicalId = periodicalId;
    }


    public LocalDateTime dateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }


}
