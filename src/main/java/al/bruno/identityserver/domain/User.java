package al.bruno.identityserver.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Entity
@Table(name = "users")
public record User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", updatable = false, insertable = false, unique = true, nullable = false)
        Long id,
        @Column(name = "first_name", nullable = false)
        String firstName,
        @Column(name = "last_name", nullable = false)
        String lastName,
        @Column(name = "username", unique = true, nullable = false)
        String username,
        @JsonIgnore
        @Column(name = "password", nullable = false)
        String password,
        @Column(name = "email", unique = true, nullable = false)
        String email,
        @Column(name = "address", nullable = false)
        String address,
        @Column(name = "phone", nullable = false)
        String phone,
        @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(
                name = "users_authority"
        )
        /*@JoinTable(
                name = "users_authority",
                joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "authority_id", referencedColumnName = "id")]
        )*/
                Collection<Authority> authorities,
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
        @Column(name = "user_date", columnDefinition = "TIMESTAMP", nullable = false)
        LocalDateTime date,
        @Column(name = "status", nullable = false)
        Boolean status
) implements OAuth2User, UserDetails, Serializable {
    @Override
    public Map<String, Object> getAttributes() {
        return new ConcurrentHashMap<>();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getName() {
        return username;
    }
}
