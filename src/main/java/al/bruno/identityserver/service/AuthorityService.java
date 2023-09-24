package al.bruno.identityserver.service;

import al.bruno.identityserver.domain.Authority;
import al.bruno.identityserver.repository.AuthorityRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService {
    private final AuthorityRepository authorityRepository;

    public AuthorityService(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }
    public Authority findAuthority(String id) {
        return authorityRepository.findById(id).orElseThrow();
    }
}
