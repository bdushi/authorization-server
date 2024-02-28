package al.bruno.identity.security;

import al.bruno.identity.federated.FederatedIdentityIdTokenCustomizer;
import al.bruno.identity.jose.Jwks;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configurers.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.oauth2.server.authorization.settings.AuthorizationServerSettings;
import org.springframework.security.oauth2.server.authorization.token.JwtEncodingContext;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.MediaTypeRequestMatcher;

@Configuration(proxyBeanMethods = false)
public class AuthorizationServerConfig {
	@Bean
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public SecurityFilterChain authorizationServerSecurityFilterChain(
			HttpSecurity http,
			RegisteredClientRepository registeredClientRepository,
			AuthorizationServerSettings authorizationServerSettings
	) throws Exception {
		OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http);
		/*
		 * This sample demonstrates the use of a public client that does not
		 * store credentials or authenticate with the authorization server.
		 *
		 * The following components show how to customize the authorization
		 * server to allow for device clients to perform requests to the
		 * OAuth 2.0 Device Authorization Endpoint and Token Endpoint without
		 * a clientId/clientSecret.
		 *
		 * CAUTION: These endpoints will not require any authentication, and can
		 * be accessed by any client that has a valid clientId.
		 *
		 * It is therefore RECOMMENDED to carefully monitor the use of these
		 * endpoints and employ any additional protections as needed, which is
		 * outside the scope of this sample.
		 */
		http
				.getConfigurer(OAuth2AuthorizationServerConfigurer.class)
				// Enable OpenID Connect 1.0
				.oidc(Customizer.withDefaults());
		http
				.exceptionHandling((exceptions) -> exceptions
						.defaultAuthenticationEntryPointFor(
								new LoginUrlAuthenticationEntryPoint("/login"),
								new MediaTypeRequestMatcher(MediaType.TEXT_HTML)
						)
				)
				.oauth2ResourceServer(
				oauth2ResourceServer ->
						oauth2ResourceServer.jwt(Customizer.withDefaults())
		);
		return http.build();
//		http.apply(new FederatedIdentityConfigure());
//		return http
//				.cors(Customizer.withDefaults())
//				.formLogin(Customizer.withDefaults())
//				.build();
	}
	@Bean
	public OAuth2TokenCustomizer<JwtEncodingContext> idTokenCustomizer() {
		return new FederatedIdentityIdTokenCustomizer();
	}
	@Bean
	public JWKSource<SecurityContext> jwkSource() {
		RSAKey rsaKey = Jwks.generateRsa();
		JWKSet jwkSet = new JWKSet(rsaKey);
		return (jwkSelector, securityContext) -> jwkSelector.select(jwkSet);
	}

	@Bean
	public JwtDecoder jwtDecoder(JWKSource<SecurityContext> jwkSource) {
		return OAuth2AuthorizationServerConfiguration.jwtDecoder(jwkSource);
	}

	@Bean
	public AuthorizationServerSettings authorizationServerSettings() {
		return AuthorizationServerSettings.builder().build();
	}

//	@Bean
//	public AuthorizationServerSettings providerSettings() {
//		return AuthorizationServerSettings.builder().issuer("http://localhost:9000").build();
//	}

}
