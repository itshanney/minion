CREATE TABLE dns_records (
    record_id               BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    domain_id               INT UNSIGNED NOT NULL,
    type                    VARCHAR(16) NOT NULL,
    name                    VARCHAR(64) NOT NULL,
    value                   VARCHAR(256) NOT NULL,
    create_date             DATETIME NOT NULL,
    is_active               BOOLEAN NOT NULL DEFAULT 1,
    PRIMARY KEY (record_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;