package model;
import java.sql.Date;
import java.time.LocalDateTime;


public class Periodical {
    private int id;
    private String title;
    private String body;
    private String category;
    private LocalDateTime dateAdded;

    public Periodical(int id, String title, String body, String category, LocalDateTime dateAdded) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.category = category;
        this.dateAdded = dateAdded;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }


}



