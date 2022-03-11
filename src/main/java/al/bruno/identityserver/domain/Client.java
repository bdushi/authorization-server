package al.bruno.identityserver.domain;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "oauth2_registered_client")
public record Client(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, insertable = false, unique = true, nullable = false)
    String id,
    @Column(name = "client_id", length = 1000)
    String clientId,
    @Column(name = "client_id_issued_at", length = 1000)
    Instant clientIdIssuedAt,
    @Column(name = "client_secret", length = 1000)
    String clientSecret,
    @Column(name = "client_secret_expires_at", length = 1000)
    Instant clientSecretExpiresAt,
    @Column(name = "client_name", length = 1000)
    String clientName,
    @Column(name = "client_authentication_methods", length = 1000)
    String clientAuthenticationMethods,
    @Column(name = "authorization_grant_types", length = 1000)
    String authorizationGrantTypes,
    @Column(name = "redirect_uris", length = 1000)
    String redirectUris,
    @Column(name = "scopes", length = 1000)
    String scopes,
    @Column(name = "client_settings", length = 2000)
    String clientSettings,
    @Column(name = "token_settings", length = 2000)
    String tokenSettings
) {
    /**
     * Default Constructor
     */
    public Client() {
        this(null, null, null, null, null, null, null, null, null, null, null, null);
    }
}