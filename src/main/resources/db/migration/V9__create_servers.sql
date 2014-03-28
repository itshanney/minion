CREATE TABLE servers (
    server_id                   BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    hostname                    VARCHAR(32) NOT NULL,
    data_center_id              VARCHAR(8) NOT NULL,
    server_type_id              INT UNSIGNED NOT NULL,
    operating_system_id         INT UNSIGNED NOT NULL,
    is_active                   BOOLEAN NOT NULL DEFAULT 1,
    create_date                 DATETIME NOT NULL,
    PRIMARY KEY (server_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;