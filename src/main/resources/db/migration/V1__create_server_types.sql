CREATE TABLE server_types (
    type_id                 INT UNSIGNED NOT NULL AUTO_INCREMENT,
    type_name               VARCHAR(32) NOT NULL,
    description             VARCHAR(255),
    cpu_type                VARCHAR(32),
    cpu_cores               INT,
    ram_gb                  DECIMAL(10,2),
    hdd_gb                  DECIMAL(10,2),
    tco_dollars             DECIMAL(10,2),
    create_date             DATETIME NOT NULL,
    PRIMARY KEY (type_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;