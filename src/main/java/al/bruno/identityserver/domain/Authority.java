package al.bruno.identityserver.domain;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "authority")
record Authority(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", updatable = false, insertable = false, unique = true, nullable = false)
        Long id,
        @Column(name = "authority_name", unique = true, updatable = false)
        String roleName,
        @Column(name = "description")
        String description
) implements GrantedAuthority, Serializable {
    @Override
    public String getAuthority() {
        return null;
    }
}
