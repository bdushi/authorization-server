CREATE TABLE oauth2_authorization_consent (
    registered_client_id varchar(100) NOT NULL,
    principal_name varchar(200) NOT NULL,
    authorities varchar(1000) NOT NULL,
    PRIMARY KEY (registered_client_id, principal_name)
);

CREATE TABLE authorization (
    id varchar(255) NOT NULL,
    registered_client_id varchar(255) NOT NULL,
    principal_name varchar(255) NOT NULL,
    authorization_grant_type varchar(255) NOT NULL,
    attributes varchar(4000) DEFAULT NULL,
    state varchar(500) DEFAULT NULL,
    authorization_code_value varchar(4000) DEFAULT NULL,
    authorization_code_issued_at timestamp DEFAULT NULL,
    authorization_code_expires_at timestamp DEFAULT NULL,
    authorization_code_metadata varchar(2000) DEFAULT NULL,
    access_token_value varchar(4000) DEFAULT NULL,
    access_token_issued_at timestamp DEFAULT NULL,
    access_token_expires_at timestamp DEFAULT NULL,
    access_token_metadata varchar(2000) DEFAULT NULL,
    access_token_type varchar(255) DEFAULT NULL,
    access_token_scopes varchar(1000) DEFAULT NULL,
    refresh_token_value blob DEFAULT NULL,
    refresh_token_issued_at timestamp DEFAULT NULL,
    refresh_token_expires_at timestamp DEFAULT NULL,
    refresh_token_metadata blob DEFAULT NULL,
    oidc_id_token_value blob DEFAULT NULL,
    oidc_id_token_issued_at timestamp DEFAULT NULL,
    oidc_id_token_expires_at timestamp DEFAULT NULL,
    oidc_id_token_metadata blob DEFAULT NULL,
    oidc_id_token_claims varchar(2000) DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE oauth2_registered_client (
    id varchar(100) NOT NULL,
    client_id varchar(100) NOT NULL,
    client_id_issued_at timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
    client_secret varchar(200) DEFAULT NULL,
    client_secret_expires_at timestamp DEFAULT NULL,
    client_name varchar(200) NOT NULL,
    client_authentication_methods varchar(1000) NOT NULL,
    authorization_grant_types varchar(1000) NOT NULL,
    redirect_uris varchar(1000) DEFAULT NULL,
    scopes varchar(1000) NOT NULL,
    client_settings varchar(2000) NOT NULL,
    token_settings varchar(2000) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS users (
        id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
        address VARCHAR(255) NOT NULL,
        user_date TIMESTAMP NOT NULL,
        email VARCHAR(255) NOT NULL,
        first_name VARCHAR(255) NOT NULL,
        last_name VARCHAR(255) NOT NULL,
        password VARCHAR(255) NOT NULL,
        phone VARCHAR(255) NOT NULL,
        username VARCHAR(255) NOT NULL,
        city_id BIGINT NOT NULL,
        country_id BIGINT NOT NULL,
        account_non_locked boolean NOT NULL,
        account_non_expired boolean NOT NULL,
        credentials_non_expired boolean NOT NULL,
        status boolean NOT NULL
            UNIQUE (email),
            UNIQUE (username),
            FOREIGN KEY (city_id) REFERENCES city(id),
            FOREIGN KEY (country_id) REFERENCES country(id)
    );

CREATE TABLE IF NOT EXISTS authority (
        id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
        description VARCHAR(255),
        authority_name VARCHAR(255),
            UNIQUE(authority_name)
    );

CREATE TABLE IF NOT EXISTS users_authority (
        user_id BIGINT NOT NULL,
        authority_id BIGINT NOT NULL,
        FOREIGN KEY (authority_id) REFERENCES authority(id),
        FOREIGN KEY (user_id) REFERENCES users(id)
    );