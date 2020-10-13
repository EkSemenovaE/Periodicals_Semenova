package model;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Periodical {
    private int id;
    private int userId;
    private String title;
    private String body;
    private String category;
    private Date created;
}



