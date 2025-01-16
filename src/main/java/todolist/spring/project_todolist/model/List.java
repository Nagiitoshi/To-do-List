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
public class List {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDateTime createDate;
    private boolean shared;

    public void addTask(){}
    public void sharedList(){}
    public void fileList(){}

}
