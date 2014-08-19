CREATE TABLE users (
    user_id                 BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    email                   VARCHAR(64) NOT NULL,
    password                VARCHAR(64) NOT NULL,
    first_name              VARCHAR(32),
    last_name               VARCHAR(32),
    is_active               BOOLEAN NOT NULL DEFAULT 1,
    create_date             DATETIME NOT NULL,
    PRIMARY KEY (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;