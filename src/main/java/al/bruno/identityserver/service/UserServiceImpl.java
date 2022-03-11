package al.bruno.identityserver.service;

import al.bruno.identityserver.domain.User;
import al.bruno.identityserver.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

@Service
public record UserServiceImpl(UserRepository userRepository) implements Consumer<OAuth2User>, UserDetailsService {
	@Override
	public void accept(OAuth2User oAuth2User) {
		// Capture user in a local data store on first authentication
		User user = userRepository.findByUsername(oAuth2User.getName());
		if (userRepository.findByUsername(user.getName()) == null) {
			System.out.println("Saving first-time user: name=" + user.getName() + ", claims=" + user.getAttributes() + ", authorities=" + user.getAuthorities());
			this.userRepository.save(user);
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.loadUserByUsername(username);
	}
}
