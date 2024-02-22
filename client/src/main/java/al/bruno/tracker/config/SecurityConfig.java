package al.bruno.tracker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
public class SecurityConfig {

//	@Bean
//	WebSecurityCustomizer webSecurityCustomizer() {
//		return (web) -> web.ignoring().requestMatchers("/webjars/**");
//	}
//
//	@Bean
//	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http
//			.authorizeHttpRequests(authorizeRequests ->
//				authorizeRequests.anyRequest().authenticated()
//			)
//			.oauth2Login(oauth2Login ->
//				oauth2Login.loginPage("/oauth2/authorization/messaging-client-oidc"))
//			.oauth2Client(withDefaults());
//		return http.build();
//	}

	@Autowired
	private ClientRegistrationRepository clientRegistrationRepository;

	@Bean
	WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().requestMatchers("/webjars/**");
	}

	// @formatter:off
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.authorizeHttpRequests(authorize ->
						authorize.anyRequest().authenticated()
				)
				.oauth2Login(oauth2Login ->
						oauth2Login.loginPage("/oauth2/authorization/messaging-client-oidc"))
				.oauth2Client(withDefaults())
				.logout(logout ->
						logout.logoutSuccessHandler(oidcLogoutSuccessHandler())
				).build();
	}

	private LogoutSuccessHandler oidcLogoutSuccessHandler() {
		OidcClientInitiatedLogoutSuccessHandler oidcLogoutSuccessHandler =
				new OidcClientInitiatedLogoutSuccessHandler(this.clientRegistrationRepository);

		// Set the location that the End-User's User Agent will be redirected to
		// after the logout has been performed at the Provider
		oidcLogoutSuccessHandler.setPostLogoutRedirectUri("{baseUrl}/index");

		return oidcLogoutSuccessHandler;
	}
}
