CREATE TABLE domains (
    domain_id               INT UNSIGNED NOT NULL AUTO_INCREMENT,
    domain_name             VARCHAR(64) NOT NULL,
    create_date             DATETIME NOT NULL,
    is_active               BOOLEAN NOT NULL DEFAULT 1,
    PRIMARY KEY (domain_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;