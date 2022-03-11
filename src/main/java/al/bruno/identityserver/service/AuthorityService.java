package al.bruno.identityserver.service;

import al.bruno.identityserver.domain.Authority;
import al.bruno.identityserver.repository.AuthorityRepository;
import org.springframework.stereotype.Service;

@Service
public record AuthorityService(AuthorityRepository authorityRepository) {
    public Authority findAuthority(Long id) {
        return authorityRepository.findById(id).orElseThrow();
    }
}
