package al.bruno.identityserver.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.Instant;

@Entity
public record Client(
    @Id
    String id,
    String clientId,
    Instant clientIdIssuedAt,
    String clientSecret,
    Instant clientSecretExpiresAt,
    String clientName,
    @Column(length = 1000)
    String clientAuthenticationMethods,
    @Column(length = 1000)
    String authorizationGrantTypes,
    @Column(length = 1000)
    String redirectUris,
    @Column(length = 1000)
    String scopes,
    @Column(length = 2000)
    String clientSettings,
    @Column(length = 2000)
    String tokenSettings
) {

}