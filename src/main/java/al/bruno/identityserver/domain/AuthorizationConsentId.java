package al.bruno.identityserver.domain;

import java.io.Serializable;
import java.util.Objects;

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