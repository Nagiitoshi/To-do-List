package todolist.spring.project_todolist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;
import todolist.spring.project_todolist.entity.Todo;

import static todolist.spring.project_todolist.TestConstants.TODO;
import static todolist.spring.project_todolist.TestConstants.TODOS;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql("/remove.sql")
class ProjectTodoListaApplicationTests {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreateTodoSuccess() {
        var todo = new Todo("todo 1", "desc todo 1", false, 1);

        webTestClient
                .post()
                .uri("/todos")
                .bodyValue(todo)
                .exchange()
                .expectStatus().isCreated()
                .expectBody()
                .jsonPath("$").isArray()
                .jsonPath("$.length()").isEqualTo(1)
                .jsonPath("$[0].name").isEqualTo(todo.getName())
                .jsonPath("$[0].description").isEqualTo(todo.getDescription())
                .jsonPath("$[0].isCompleted").isEqualTo(todo.getIsCompleted())
                .jsonPath("$[0].priority").isEqualTo(todo.getPriority());
    }

    @Test
    public void testCreateTodoFailure() {
        webTestClient
                .post()
                .uri("/todos")
                .bodyValue(
                        new Todo("", "", false, 0))
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Sql("/import.sql")
    @Test
    public void testUpdateTodoSuccess() {
        var todo = new Todo(TODO.getId(), TODO.getName() + " Up", TODO.getName() + " Up", !TODO.getIsCompleted(),
                TODO.getPriority() + 1);

        webTestClient
                .put()
                .uri("/todos/" + TODO.getId())
                .bodyValue(todo)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$").isArray()
                .jsonPath("$.length()").isEqualTo(5)
                .jsonPath("$[0].name").isEqualTo(todo.getName())
                .jsonPath("$[0].description").isEqualTo(todo.getDescription())
                .jsonPath("$[0].isCompleted").isEqualTo(todo.getIsCompleted())
                .jsonPath("$[0].priority").isEqualTo(todo.getPriority());
    }

    @Test
    public void testUpdateTodoFailure() {
        var unexinstingId = 1L;

        webTestClient
                .put()
                .uri("/todos/" + unexinstingId)
                .bodyValue(
                        new Todo(unexinstingId, "", "", false, 0))
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Sql("/import.sql")
    @Test
    public void testDeleteTodoSuccess() {
        webTestClient
                .delete()
                .uri("/todos/" + TODOS.get(0).getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$").isArray()
                .jsonPath("$.length()").isEqualTo(4)
                .jsonPath("$[0].name").isEqualTo(TODOS.get(1).getName())
                .jsonPath("$[0].description").isEqualTo(TODOS.get(1).getDescription())
                .jsonPath("$[0].isCompleted").isEqualTo(TODOS.get(1).getIsCompleted())
                .jsonPath("$[0].priority").isEqualTo(TODOS.get(1).getPriority());
    }

    @Test
    public void testDeleteTodoFailure() {
        var unexinstingId = 1L;

        webTestClient
                .delete()
                .uri("/todos/" + unexinstingId)
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Sql("/import.sql")
    @Test
    public void testListTodos() throws Exception {
        webTestClient
                .get()
                .uri("/todos")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$").isArray()
                .jsonPath("$.length()").isEqualTo(5)
                .jsonPath("$[0].id").isEqualTo(TODOS.get(0).getId())
                .jsonPath("$[0].name").isEqualTo(TODOS.get(0).getName())
                .jsonPath("$[0].description").isEqualTo(TODOS.get(0).getDescription())
                .jsonPath("$[0].isCompleted").isEqualTo(TODOS.get(0).getIsCompleted())
                .jsonPath("$[0].priority").isEqualTo(TODOS.get(0).getPriority());
    }


}
