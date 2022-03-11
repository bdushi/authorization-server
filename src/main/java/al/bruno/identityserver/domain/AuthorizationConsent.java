package al.bruno.identityserver.domain;

import al.bruno.identityserver.domain.AuthorizationConsent.AuthorizationConsentId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "oauth2_authorization_consent")
@IdClass(AuthorizationConsentId.class)
public record AuthorizationConsent(
        @Id
        @Column(name = "registered_client_id", updatable = false, insertable = false, unique = true, nullable = false)
        String registeredClientId,
        @Id
        @Column(name = "principal_name", updatable = false, insertable = false, unique = true, nullable = false)
        String principalName,
        @Column(name = "authorities", length = 1000)
        String authorities
) {
    public record AuthorizationConsentId(
            String registeredClientId,
            String principalName
    ) implements Serializable {
        /**
         * Default Constructor
         */
        public AuthorizationConsentId() {
            this(null, null);
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            var that = (AuthorizationConsentId) o;
            return registeredClientId.equals(that.registeredClientId) && principalName.equals(that.principalName);
        }
        @Override
        public int hashCode() {
            return Objects.hash(registeredClientId, principalName);
        }
    }
    /**
     * Default Constructor
     */
    public AuthorizationConsent() {
        this(null, null, null);
    }
}