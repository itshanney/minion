CREATE TABLE ssl_certificates (
    certificate_id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
    certificate_name        VARCHAR(64) NOT NULL,
    domain_id               INT UNSIGNED NOT NULL,
    expiration_date         DATETIME NOT NULL,
    create_date             DATETIME NOT NULL,
    is_active               BOOLEAN NOT NULL DEFAULT 1,
    PRIMARY KEY (certificate_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;