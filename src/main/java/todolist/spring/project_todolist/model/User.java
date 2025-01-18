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

    public void createList(String title, String description, boolean shared) {
        Listas newList = new Listas(title, description);

        // Inicializar a lista 'listas' se ela ainda não tiver sido inicializada
        if (listas == null) {
            listas = new ArrayList<>();
        }

        // Configurar o relacionamento bidirecional para garantir que a nova lista saiba a qual usuário pertence
        newList.setCreateDate(LocalDateTime.now());
        newList.setShared(shared);
        newList.setUser(this);

        // Adicionar a nova lista à coleção 'listas' do usuário
        listas.add(newList);
    }

    public void manageProfile(String newName, String newEmail) {
        // Validação simples de exemplo
        if (newName == null || newName.isEmpty()) {
            throw new IllegalArgumentException("This name cannot be empty!!");
        }
        if (newEmail == null || newEmail.isEmpty()) {
            throw new IllegalArgumentException("This email cannot be empty!!");
        }
        // Atualiza os atributos
        this.name = newName;
        this.email = newEmail;
    }

}
