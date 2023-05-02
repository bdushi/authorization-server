package al.bruno.identityserver.domain;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "oauth2_authorization")
public class Authorization {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, insertable = false, unique = true, nullable = false)
    private final String id;
    @Column(name = "registered_client_id", length = 4000)
    private final String registeredClientId;
    @Column(name = "principal_name")
    private final String principalName;
    @Column(name = "authorization_grant_type")
    private final String authorizationGrantType;
    @Column(name = "attributes")
    private final String attributes;
    @Column(name = "state", length = 500)
    private final String state;
    @Column(name = "authorization_code_value")
    private String authorizationCodeValue;
    @Column(name = "authorization_code_issued_at")
    private Instant authorizationCodeIssuedAt;
    @Column(name = "authorization_code_expires_at")
    private Instant authorizationCodeExpiresAt;
    @Column(name = "authorization_code_metadata")
    private String authorizationCodeMetadata;
    @Column(name = "access_token_value")
    private String accessTokenValue;
    @Column(name = "access_token_issued_at")
    private Instant accessTokenIssuedAt;
    @Column(name = "access_token_expires_at")
    private Instant accessTokenExpiresAt;
    @Column(name = "access_token_metadata", length = 2000)
    private String accessTokenMetadata;
    @Column(name = "access_token_type")
    private String accessTokenType;
    @Column(name = "access_token_scopes", length = 1000)
    private String accessTokenScopes;
    @Column(name = "refresh_token_value")
    private String refreshTokenValue;
    @Column(name = "refresh_token_issued_at")
    private Instant refreshTokenIssuedAt;
    @Column(name = "refresh_token_expires_at")
    private Instant refreshTokenExpiresAt;
    @Column(name = "refresh_token_metadata", length = 2000)
    private String refreshTokenMetadata;
    @Column(name = "oidc_id_token_value")
    private String oidcIdTokenValue;
    @Column(name = "oidc_id_token_issued_at")
    private Instant oidcIdTokenIssuedAt;
    @Column(name = "oidc_id_token_expires_at")
    private Instant oidcIdTokenExpiresAt;
    @Column(name = "oidc_id_token_metadata", length = 2000)
    private String oidcIdTokenMetadata;
    @Column(name = "oidc_id_token_claims", length = 2000)
    private String oidcIdTokenClaims;

    public Authorization(
            String id,
            String registeredClientId,
            String principalName,
            String authorizationGrantType,
            String attributes,
            String state) {
        this.id = id;
        this.registeredClientId = registeredClientId;
        this.principalName = principalName;
        this.authorizationGrantType = authorizationGrantType;
        this.attributes = attributes;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public String getRegisteredClientId() {
        return registeredClientId;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public String getAuthorizationGrantType() {
        return authorizationGrantType;
    }

    public String getAttributes() {
        return attributes;
    }

    public String getState() {
        return state;
    }

    public String getAuthorizationCodeValue() {
        return authorizationCodeValue;
    }

    public void setAuthorizationCodeValue(String authorizationCodeValue) {
        this.authorizationCodeValue = authorizationCodeValue;
    }

    public Instant getAuthorizationCodeIssuedAt() {
        return authorizationCodeIssuedAt;
    }

    public void setAuthorizationCodeIssuedAt(Instant authorizationCodeIssuedAt) {
        this.authorizationCodeIssuedAt = authorizationCodeIssuedAt;
    }

    public Instant getAuthorizationCodeExpiresAt() {
        return authorizationCodeExpiresAt;
    }

    public void setAuthorizationCodeExpiresAt(Instant authorizationCodeExpiresAt) {
        this.authorizationCodeExpiresAt = authorizationCodeExpiresAt;
    }

    public String getAuthorizationCodeMetadata() {
        return authorizationCodeMetadata;
    }

    public void setAuthorizationCodeMetadata(String authorizationCodeMetadata) {
        this.authorizationCodeMetadata = authorizationCodeMetadata;
    }

    public String getAccessTokenValue() {
        return accessTokenValue;
    }

    public void setAccessTokenValue(String accessTokenValue) {
        this.accessTokenValue = accessTokenValue;
    }

    public Instant getAccessTokenIssuedAt() {
        return accessTokenIssuedAt;
    }

    public void setAccessTokenIssuedAt(Instant accessTokenIssuedAt) {
        this.accessTokenIssuedAt = accessTokenIssuedAt;
    }

    public Instant getAccessTokenExpiresAt() {
        return accessTokenExpiresAt;
    }

    public void setAccessTokenExpiresAt(Instant accessTokenExpiresAt) {
        this.accessTokenExpiresAt = accessTokenExpiresAt;
    }

    public String getAccessTokenMetadata() {
        return accessTokenMetadata;
    }

    public void setAccessTokenMetadata(String accessTokenMetadata) {
        this.accessTokenMetadata = accessTokenMetadata;
    }

    public String getAccessTokenType() {
        return accessTokenType;
    }

    public void setAccessTokenType(String accessTokenType) {
        this.accessTokenType = accessTokenType;
    }

    public String getAccessTokenScopes() {
        return accessTokenScopes;
    }

    public void setAccessTokenScopes(String accessTokenScopes) {
        this.accessTokenScopes = accessTokenScopes;
    }

    public String getRefreshTokenValue() {
        return refreshTokenValue;
    }

    public void setRefreshTokenValue(String refreshTokenValue) {
        this.refreshTokenValue = refreshTokenValue;
    }

    public Instant getRefreshTokenIssuedAt() {
        return refreshTokenIssuedAt;
    }

    public void setRefreshTokenIssuedAt(Instant refreshTokenIssuedAt) {
        this.refreshTokenIssuedAt = refreshTokenIssuedAt;
    }

    public Instant getRefreshTokenExpiresAt() {
        return refreshTokenExpiresAt;
    }

    public void setRefreshTokenExpiresAt(Instant refreshTokenExpiresAt) {
        this.refreshTokenExpiresAt = refreshTokenExpiresAt;
    }

    public String getRefreshTokenMetadata() {
        return refreshTokenMetadata;
    }

    public void setRefreshTokenMetadata(String refreshTokenMetadata) {
        this.refreshTokenMetadata = refreshTokenMetadata;
    }

    public String getOidcIdTokenValue() {
        return oidcIdTokenValue;
    }

    public void setOidcIdTokenValue(String oidcIdTokenValue) {
        this.oidcIdTokenValue = oidcIdTokenValue;
    }

    public Instant getOidcIdTokenIssuedAt() {
        return oidcIdTokenIssuedAt;
    }

    public void setOidcIdTokenIssuedAt(Instant oidcIdTokenIssuedAt) {
        this.oidcIdTokenIssuedAt = oidcIdTokenIssuedAt;
    }

    public Instant getOidcIdTokenExpiresAt() {
        return oidcIdTokenExpiresAt;
    }

    public void setOidcIdTokenExpiresAt(Instant oidcIdTokenExpiresAt) {
        this.oidcIdTokenExpiresAt = oidcIdTokenExpiresAt;
    }

    public String getOidcIdTokenMetadata() {
        return oidcIdTokenMetadata;
    }

    public void setOidcIdTokenMetadata(String oidcIdTokenMetadata) {
        this.oidcIdTokenMetadata = oidcIdTokenMetadata;
    }

    public String getOidcIdTokenClaims() {
        return oidcIdTokenClaims;
    }

    public void setOidcIdTokenClaims(String oidcIdTokenClaims) {
        this.oidcIdTokenClaims = oidcIdTokenClaims;
    }
}
