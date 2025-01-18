package todolist.spring.project_todolist.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private LocalDateTime dateTime;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Listas> listas;

    public void createList(String title, String description) {

        Listas newList = new Listas(title, description);
        // Configurar o relacionamento bidirecional para garantir que a nova lista saiba a qual usuário pertence
        newList.setUser(this);
       // Inicializar a lista 'listas' se ela ainda não tiver sido inicializada
        if (listas == null) {
            listas = new ArrayList<>();
        }
        // Adicionar a nova lista à coleção 'listas' do usuário
        listas.add(newList);
    }

    public void manageProfile() {


    }

}
