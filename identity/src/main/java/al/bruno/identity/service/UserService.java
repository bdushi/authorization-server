package al.bruno.identity.service;

import al.bruno.identity.domain.User;
import al.bruno.identity.repository.AuthorityRepository;
import al.bruno.identity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.function.Consumer;

@Service
public class UserService implements Consumer<OAuth2User>, UserDetailsService {

	private final UserRepository userRepository;
	private final AuthorityRepository authorityRepository;

	@Autowired
	public UserService(UserRepository userRepository, AuthorityRepository authorityRepository) {
		this.userRepository = userRepository;
		this.authorityRepository = authorityRepository;
	}

	@Override
	public void accept(OAuth2User user) {
		if (userRepository.loadUserByUsername(user.getAttribute("name")) == null) {
			userRepository.save(
					new User(
							user.getAttribute("given_name"),
							user.getAttribute("family_name"),
							user.getAttribute("name"),
							user.getAttribute("email"),
							Collections.emptyList(),
							OffsetDateTime.now(),
							OffsetDateTime.now(),
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
