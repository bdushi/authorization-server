package al.bruno.identityserver.service;

import al.bruno.identityserver.domain.User;
import al.bruno.identityserver.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.function.Consumer;

@Service
public record UserServiceImpl(
		UserRepository userRepository,
		AuthorityService authorityService
) implements Consumer<OAuth2User>, UserDetailsService {
	@Override
	public void accept(OAuth2User user) {
		// Capture user in a local data store on first authentication
		if (userRepository.findByUsername(user.getAttribute("name")) == null) {
			System.out.println("Saving first-time user: name=" + user.getName() + ", claims=" + user.getAttributes() + ", authorities=" + user.getAuthorities());
			userRepository.save(
					new User(
							user.getAttribute("given_name"),
							user.getAttribute("family_name"),
							user.getAttribute("name"),
							user.getAttribute("email"),
							Collections.singleton(authorityService.findAuthority(1L)),
							LocalDateTime.now(),
							true,
							true,
							true,
							true
					)
			);
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.loadUserByUsername(username);
	}
}
