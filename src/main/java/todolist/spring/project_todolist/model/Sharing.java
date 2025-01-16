package todolist.spring.project_todolist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Sharing {

    public enum TipoPermissao {
        LEITURA,
        ESCRITA,
        ADMINISTRACAO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime DateShared;
    private TipoPermissao TypePermission;

    public void setPermission(){}
    public void revokeAccess(){}

}

