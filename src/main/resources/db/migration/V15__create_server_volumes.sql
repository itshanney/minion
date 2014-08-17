CREATE TABLE server_volumes (
    volume_id                   BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    server_id                   BIGINT UNSIGNED NOT NULL,
    size_gb                     DECIMAL(10,2) NOT NULL,
    mount_point                 VARCHAR(128) NOT NULL,
    is_active                   BOOLEAN NOT NULL DEFAULT 1,
    create_date                 DATETIME NOT NULL,
    PRIMARY KEY (volume_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;