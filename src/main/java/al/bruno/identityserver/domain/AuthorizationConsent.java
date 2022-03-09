package al.bruno.identityserver.domain;

import jakarta.persistence.IdClass;
import al.bruno.identityserver.domain.AuthorizationConsent.AuthorizationConsentId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.util.*;

@Entity
@IdClass(AuthorizationConsentId.class)
public record AuthorizationConsent(
        @Id
        String registeredClientId,
        @Id
        String principalName,
        @Column(length = 1000)
        String authorities
) {
    public record AuthorizationConsentId(
            String registeredClientId,
            String principalName
    ) implements Serializable {
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
}