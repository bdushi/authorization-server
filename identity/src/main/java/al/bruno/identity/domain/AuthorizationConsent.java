package al.bruno.identity.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "oauth2_authorization_consent")
@IdClass(AuthorizationConsentId.class)
public class AuthorizationConsent {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "registered_client_id", updatable = false, insertable = false, unique = true, nullable = false)
    private String registeredClientId;
    @Id
    @Column(name = "principal_name", updatable = false, insertable = false, unique = true, nullable = false)
    private String principalName;
    @Column(name = "authorities", length = 1000)
    private String authorities;


    public AuthorizationConsent(String registeredClientId, String principalName, String authorities) {
        this.registeredClientId = registeredClientId;
        this.principalName = principalName;
        this.authorities = authorities;
    }

    public String getRegisteredClientId() {
        return registeredClientId;
    }

    public void setRegisteredClientId(String registeredClientId) {
        this.registeredClientId = registeredClientId;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }
}