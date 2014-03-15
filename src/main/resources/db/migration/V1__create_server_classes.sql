CREATE TABLE server_classes (
    class_id            INT UNSIGNED NOT NULL AUTO_INCREMENT,
    class_name          VARCHAR(32) NOT NULL,
    description         VARCHAR(255),
    create_date         DATETIME NOT NULL,
    PRIMARY KEY (class_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;