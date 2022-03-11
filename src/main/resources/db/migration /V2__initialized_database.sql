INSERT INTO oauth2_registered_client (id, client_id, client_name, client_secret, client_authentication_methods, client_settings, authorization_grant_types, redirect_uris, scopes, token_settings)
    VALUES
    ('messaging-client', 'track system', '{noop}secret', 'client_secret_basic', 'settings', 'authorization_code', 'http://127.0.0.1:8080/login/oauth2/code/messaging-client-oidc', 'openid', '+require-authorization-consent', 'token');

INSERT INTO users (username, last_name, first_name, password, email, address, phone, zip_code, user_date, account_non_locked, account_non_expired, credentials_non_expired, status)
    VALUES
    ('admin', 'Administrator', 'Administrator', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'brddev@gmail.com', 'Rruga Medar Shtylla', '+355699897887', '1001', now(), false, false, false, true);

INSERT INTO authority (authority, description)
    VALUES
     ('ADMIN', 'Administrator'),
     ('CLIENT', 'Klient'),
     ('COURIER', 'Korrier');

INSERT INTO user_authority (user_id, authority_id)
    VALUES
    (1, 1);