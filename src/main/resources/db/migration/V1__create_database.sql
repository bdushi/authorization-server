--Enable the uuid-ossp extension if it's not already enabled
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE oauth2_authorization_consent (
    registered_client_id varchar(100) NOT NULL,
    principal_name varchar(200) NOT NULL,
    authorities varchar(1000) NOT NULL,
    PRIMARY KEY (registered_client_id, principal_name)
);

CREATE TABLE oauth2_authorization (
    id varchar(255) NOT NULL,
    registered_client_id varchar(255) NOT NULL,
    principal_name varchar(255) NOT NULL,
    authorization_grant_type varchar(255) NOT NULL,
    attributes text DEFAULT NULL,
    state varchar(500) DEFAULT NULL,
    authorization_code_value text DEFAULT NULL,
    authorization_code_issued_at timestamp DEFAULT NULL,
    authorization_code_expires_at timestamp DEFAULT NULL,
    authorization_code_metadata varchar(2000) DEFAULT NULL,
    access_token_value text DEFAULT NULL,
    access_token_issued_at timestamp DEFAULT NULL,
    access_token_expires_at timestamp DEFAULT NULL,
    access_token_metadata varchar(2000) DEFAULT NULL,
    access_token_type varchar(255) DEFAULT NULL,
    access_token_scopes varchar(1000) DEFAULT NULL,
    refresh_token_value text DEFAULT NULL,
    refresh_token_issued_at timestamp DEFAULT NULL,
    refresh_token_expires_at timestamp DEFAULT NULL,
    refresh_token_metadata text DEFAULT NULL,
    oidc_id_token_value text DEFAULT NULL,
    oidc_id_token_issued_at timestamp DEFAULT NULL,
    oidc_id_token_expires_at timestamp DEFAULT NULL,
    oidc_id_token_metadata text DEFAULT NULL,
    oidc_id_token_claims varchar(2000) DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE oauth2_registered_client (
    id varchar PRIMARY KEY,
    client_id varchar NOT NULL,
    client_id_issued_at timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
    client_secret varchar DEFAULT NULL,
    client_secret_expires_at timestamp DEFAULT NULL,
    client_name varchar NOT NULL,
    client_authentication_methods varchar NOT NULL,
    authorization_grant_types varchar NOT NULL,
    redirect_uris varchar DEFAULT NULL,
    post_logout_redirect_uris varchar DEFAULT NULL,
    scopes varchar NOT NULL,
    client_settings varchar NOT NULL,
    token_settings varchar NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
    id VARCHAR DEFAULT uuid_generate_v4() PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255),
    address VARCHAR(255),
    phone VARCHAR(255),
    zip_code VARCHAR(255),
    account_non_locked boolean NOT NULL,
    account_non_expired boolean NOT NULL,
    credentials_non_expired boolean NOT NULL,
    status boolean NOT NULL,
    date_created TIMESTAMP NOT NULL,
    last_updated TIMESTAMP NOT NULL
    );

CREATE TABLE IF NOT EXISTS authority (
    id VARCHAR DEFAULT uuid_generate_v4() PRIMARY KEY,
    description VARCHAR(255),
    authority VARCHAR(255) NOT NULL UNIQUE,
    date_created TIMESTAMP NOT NULL,
    last_updated TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS user_authority (
    user_id VARCHAR NOT NULL,
    authority_id VARCHAR NOT NULL,
    FOREIGN KEY (authority_id) REFERENCES authority(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);