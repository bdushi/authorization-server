INSERT INTO oauth2_registered_client (id, client_id, client_secret, client_authentication_methods, authorization_grant_types, redirect_uris, scopes, client_settings)
    VALUES
    ('messaging-client', '{noop}secret', 'client_secret_basic', 'authorization_code', '"http://127.0.0.1:8080/login/oauth2/code/messaging-client-oidc"', 'openid', '+require-authorization-consent');

INSERT INTO users (username, last_name, first_name, password, email, address, phone, city, state, zip_code, user_date, account_non_locked, account_non_expired, credentials_non_expired, status)
    VALUES
    ('admin', 'Administrator', 'Administrator', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'brddev@gmail.com', 'Rruga Medar Shtylla', '+355699897887', 'Albania', '1001', 'Tirane', now(), false, false, false, true);

INSERT INTO authority (authority_name, description, authority_order)
    VALUES
     ('ADMIN', 'Administrator', 1),
     ('CLIENT', 'Klient', 2),
     ('COURIER', 'Korrier', 2);

INSERT INTO users_authority (user_id, authority_id)
    VALUES
    (1, 1);