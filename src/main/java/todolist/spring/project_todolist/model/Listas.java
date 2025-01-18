package todolist.spring.project_todolist.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Listas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDateTime createDate;
    private boolean shared;
    private User user;

    public Listas(String title, String description) {
        this.title = title;
        this.description = description;

    }

    public void addTask(){}
    public void sharedList(){}
    public void fileList(){}

    public void setUser(User user) {
        this.user = user;
        if (user != null && !user.getListas().contains(this)) {
            user.getListas().add(this);
        }
    }


}
