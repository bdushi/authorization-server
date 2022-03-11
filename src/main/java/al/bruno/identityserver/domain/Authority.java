package al.bruno.identityserver.domain;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "authority")
public record Authority(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", updatable = false, insertable = false, unique = true, nullable = false)
        Long id,
        @Column(name = "authority", unique = true, updatable = false)
        String authority,
        @Column(name = "description")
        String description
) implements GrantedAuthority, Serializable {
    @Override
    public String getAuthority() {
        return authority;
    }

    /**
     * Default Constructor
     */
    public Authority() {
        this(null, null, null);
    }
}
