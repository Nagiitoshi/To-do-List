package todolist.spring.project_todolist.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;


@Entity
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @JsonProperty("isCompleted")
    private Boolean isCompleted;
    private int priority;

    public Todo() {
    }
    public Todo(Long id, String name, String description, Boolean isCompleted, int priority) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isCompleted = isCompleted;
        this.priority = priority;
    }


    public Todo(String name, String description, boolean isCompleted, int priority) {
        this.name = name;
        this.description = description;
        this.isCompleted = isCompleted;
        this.priority = priority;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Referência na memória
        if (o == null || getClass() != o.getClass()) return false; // Verifica classe
        Todo todo = (Todo) o;
        return Objects.equals(id, todo.id) &&
                Objects.equals(name, todo.name) &&
                Objects.equals(description, todo.description) &&
                Objects.equals(isCompleted, todo.isCompleted) &&
                Objects.equals(priority, todo.priority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, isCompleted, priority);
    }




public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        this.isCompleted = completed;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
