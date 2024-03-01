package al.bruno.identity.domain;

import java.io.Serializable;
import java.util.Objects;

//public record AuthorizationConsentId(
//        String registeredClientId,
//        String principalName
//) implements Serializable {
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        var that = (AuthorizationConsentId) o;
//        return registeredClientId.equals(that.registeredClientId) && principalName.equals(that.principalName);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(registeredClientId, principalName);
//    }
//}

public class AuthorizationConsentId implements Serializable {
    private String registeredClientId;
    private String principalName;

    // @fold:on
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
    // @fold:off

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorizationConsentId that = (AuthorizationConsentId) o;
        return registeredClientId.equals(that.registeredClientId) && principalName.equals(that.principalName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registeredClientId, principalName);
    }
}