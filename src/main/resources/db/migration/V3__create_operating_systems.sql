CREATE TABLE operating_systems (
    operating_system_id             VARCHAR(8) NOT NULL,
    operating_system_name           VARCHAR(32) NOT NULL,
    create_date                     DATETIME NOT NULL,
    PRIMARY KEY(operating_system_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;