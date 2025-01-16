package todolist.spring.project_todolist.model;
import jakarta.annotation.Priority;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Task {
    public enum Prioridade {
        BAIXA,
        MEDIA,
        ALTA
    }
    public enum Status {
        PENDENTE,
        EM_ANDAMENTO,
        CONCLUIDO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDateTime createDate;
    private LocalDateTime dateDue;
    private Prioridade priority;
    private Status status;
    private boolean favorite;


    public void markDone(){}
    public void setPriority(){}
    public void addSubtask(){}

}