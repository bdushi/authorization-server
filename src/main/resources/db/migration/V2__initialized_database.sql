--INSERT
--    INTO
--        users (username, last_name, first_name, password, email, address, phone, zip_code, user_date, account_non_locked, account_non_expired, credentials_non_expired, status)
--    VALUES
--        ('admin', 'Administrator', 'Administrator', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'brddev@gmail.com', 'Rruga Medar Shtylla', '+355699897887', '1001', now(), false, false, false, true);

INSERT
    INTO
        authority
        (
            authority,
            description,
            date_created,
            last_updated
        )
    VALUES
        ('ADMIN', 'Administrator', now(), now()),
        ('CLIENT', 'Klient', now(), now()),
        ('COURIER', 'Korrier', now(), now());

--INSERT
--    INTO
--        user_authority (user_id, authority_id)
--    VALUES
--        (1, 1);

INSERT INTO oauth2_registered_client (
    id,
    client_id,
    client_secret,
    client_id_issued_at,
    client_secret_expires_at,
    client_name,
    client_authentication_methods,
    authorization_grant_types,
    redirect_uris,
    post_logout_redirect_uris,
    scopes,
    client_settings,
    token_settings)
VALUES (
    '805059a7-a8b5-4c9f-8821-8b413f70f651',
    'messaging-client',
    '{noop}secret',
    now(),
    now(),
    '24f950b8-d0f9-4ba9-9d20-aba68d814f11',
    'client_secret_basic',
    'refresh_token,client_credentials,authorization_code',
    'http://127.0.0.1:8080/authorized, http://127.0.0.1:8080/login/oauth2/code/messaging-client-oidc',
    'http://127.0.0.1:8080/index',
    'openid,profile,message.read,message.write',
    '{"settings.client.require-proof-key":false, "settings.client.require-authorization-consent":true}',
    '{"settings.token.reuse-refresh-tokens":true, "settings.token.id-token-signature-algorithm":"RS256", "settings.token.access-token-time-to-live":"PT5M", "settings.token.access-token-format":"self-contained", "settings.token.refresh-token-time-to-live":"PT1H", "settings.token.authorization-code-time-to-live":"PT5M", "settings.token.device-code-time-to-live":"PT5M"}'
 );
