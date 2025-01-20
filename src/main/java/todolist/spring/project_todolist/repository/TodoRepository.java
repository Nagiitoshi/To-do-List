package todolist.spring.project_todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import todolist.spring.project_todolist.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
