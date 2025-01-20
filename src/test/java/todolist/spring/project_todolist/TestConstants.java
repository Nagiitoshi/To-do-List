package todolist.spring.project_todolist;

import org.w3c.dom.stylesheets.LinkStyle;
import todolist.spring.project_todolist.entity.Todo;

import java.util.ArrayList;
import java.util.List;

public class TestConstants {
    public static final List<Todo> TODOS = new ArrayList<>() {
        {
            add(new Todo(9995L, "nagiItoshi", "Casa", false, 1));
            add(new Todo(9996L, "nagiItoshi", "Carro", false, 1));
            add(new Todo(9997L, "nagiItoshi", "Listas", false, 1));
            add(new Todo(9998L, "nagiItoshi", "Sorry", false, 1));
            add(new Todo(9999L, "nagiItoshi", "Anime", false, 1));
        }
    };
    public static final Todo TODO = TODOS.getFirst();
}
